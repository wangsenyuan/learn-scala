package codechef.easy.sanskar;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by wangsenyuan on 06/03/2017.
 */
public class Solution {

    public static void main(String[] args) {
        int M = pow(2, 21);

        boolean[][] dp = new boolean[9][M];

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        scanner.nextLine();

        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();

            scanner.nextLine();

            long[] a = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextLong();
            }
            scanner.nextLine();

            boolean res = canDivide(a, n, k, dp);

            if (res) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

    private static int pow(int a, int n) {
        if (n == 0) {
            return 1;
        }
        int b = pow(a, n / 2);
        int c = b * b;
        if (n % 2 == 1) {
            return c * a;
        }
        return c;
    }

    private static boolean canDivide(long[] a, int n, int K, boolean[][] dp) {
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }

        if (sum % K != 0) {
            return false;
        }

        int M = pow(2, n);
        long x = sum / K;

        for (int k = 0; k <= K; k++) {
            Arrays.fill(dp[k], false);
        }

        dp[0][0] = true;

        for (int k = 0; k < K; k++) {
            for (int bitMask = 0; bitMask < M; bitMask++) {
                if (!dp[k][bitMask]) {
                    continue;
                }
                sum = 0L;
                for (int i = 0; i < n; i++) {
                    if ((bitMask & (1 << i)) == 0) {
                        continue;
                    }
                    sum += a[i];
                }
                sum -= x * k;

                for (int i = 0; i < n; i++) {
                    if ((bitMask & (1 << i)) > 0) {
                        continue;
                    }

                    int newMask = bitMask | (1 << i);
                    if (sum + a[i] == x) {
                        dp[k + 1][newMask] = true;
                    } else if (sum + a[i] < x) {
                        dp[k][newMask] = true;
                    }
                }
            }
        }


        return dp[K][M - 1];
    }
}
