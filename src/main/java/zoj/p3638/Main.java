package zoj.p3638;

import java.util.Scanner;

import static java.lang.Character.isDigit;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int m = in.nextInt();
            if (n == 0) {
                break;
            }
            int[] fruits = new int[n];
            int p = 0;
            in.nextLine();
            while (true) {
                String line = in.nextLine();
                if (line.length() < 2) {
                    break;
                }
                int want = parseFruit(line);
                if (want > 0) {
                    m -= want + 1;
                } else {
                    fruits[p++] = -want;
                }
            }

            int res = solve(n, m, fruits, p);

            System.out.println(res);
        }
    }

    private static int solve(int n, int m, int[] arr, int p) {
        if (m < 0) {
            return 0;
        }

        int ans = 0;
        int all = 1 << p;

        for (int mask = 0; mask < all; mask++) {
            int ones = 0;
            int tmp = 0;
            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 1) == 1) {
                    ones++;
                    tmp += arr[i];
                }
            }

            if ((ones & 1) == 1) {
                ans = modSub(ans, C(n + m - 1 - tmp, n - 1));
            } else {
                ans = modAdd(ans, C(n + m - 1 - tmp, n - 1));
            }
        }

        return ans;
    }

    private static int C(int n, int r) {
        if (n < r || n < 0 || r < 0) {
            return 0;
        }
        int ret0 = 1;
        int ret1 = 1;

        for (int i = 0; i < r; i++) {
            ret0 = modMul(ret0, n - i);
            ret1 = modMul(ret1, i + 1);
        }

        return modMul(ret0, inverse(ret1));
    }

    private static int inverse(int n) {
        return pow(n, MOD - 2);
    }

    private static int pow(int a, int b) {
        int res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = modMul(res, a);
            }
            a = modMul(a, a);
            b >>= 1;
        }

        return res;
    }

    private static int exgcd(int a, int b, int[] x, int[] y) {
        if (b == 0) {
            x[0] = 1;
            y[0] = 0;
            return a;
        }
        int[] nx = new int[1];
        int[] ny = new int[1];
        int d = exgcd(b, a % b, nx, ny);
        int t = nx[0] % MOD;
        x[0] = ny[0] % MOD;
        y[0] = (t - a / b * x[0]) % MOD;
        return d;
    }


    private static int modMul(int a, int b) {
        long res = 1L * a * b;
        return (int) (res % MOD);
    }

    private static int modAdd(int a, int b) {
        a += b;
        if (a >= MOD) {
            a -= MOD;
        }
        return a;
    }

    private static int modSub(int a, int b) {
        return modAdd(a, MOD - b);
    }

    private static int parseFruit(String fruit) {
        int i = fruit.indexOf(":");
        int sign = 1;
        if (fruit.charAt(i + 2) == 'l') {
            sign = -1;
        }
        int j = fruit.length();
        while (isDigit(fruit.charAt(j - 1))) {
            j--;
        }
        int val = Integer.parseInt(fruit.substring(j));

        return sign * val;
    }


    private static final int MOD = 100000007;
}
