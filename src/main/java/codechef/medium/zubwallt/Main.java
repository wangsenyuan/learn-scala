package codechef.medium.zubwallt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Predicate;

public class Main {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int tc = reader.nextInt();
        while (tc-- > 0) {
            int n = reader.nextInt();
            for (int i = 0; i < n; i++) {
                A[i] = reader.nextInt();
            }
            System.out.println(solve(n, A));
        }
    }

    static int MAX_N = 100010;
    static int b[] = {10, 20, 50, 100, 200, 500, 2000};
    static int[][][] dp = new int[MAX_N][1 << 7][8];
    static int A[] = new int[MAX_N];

    private static int solve(int n, int[] A) {

        for (int i = 0; i < n; i++) {
            int a = A[i];
            A[i] = search(b.length, j -> b[j] >= a);
        }

        for (int i = 0; i <= n; i++) {
            for (int mask = 0; mask < 1 << 7; mask++) {
                for (int k = 0; k < 8; k++) {
                    dp[i][mask][k] = -1;
                }
            }
        }

        dp[0][0][7] = 0;

        for (int i = 0; i < n; i++) {
            for (int mask = 0; mask < 1 << 7; mask++) {
                for (int who = 0; who <= 7; who++) {
                    if (dp[i][mask][who] < 0) {
                        continue;
                    }
                    dp[i + 1][mask][who] = max(dp[i + 1][mask][who], dp[i][mask][who]);
                    if (who == A[i]) {
                        dp[i + 1][mask][who] = max(dp[i + 1][mask][who], dp[i][mask][who] + 1);
                    }
                    if ((mask & (1 << A[i])) == 0) {
                        dp[i + 1][mask | (1 << A[i])][A[i]] =
                            max(dp[i + 1][mask | (1 << A[i])][A[i]], dp[i][mask][who] + 1);
                    }
                }
            }
        }

        int res = 0;

        for (int mask = 0; mask < 1 << 7; mask++) {
            for (int who = 0; who < 7; who++) {
                res = max(res, dp[n][mask][who]);
            }
        }
        return n - res;
    }

    private static int max(int a, int b) {
        if (a >= b) {
            return a;
        }
        return b;
    }

    private static int search(int n, Predicate<Integer> fn) {
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = (left + right) / 2;
            if (fn.test(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
