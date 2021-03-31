package codechef.easy.section1.maxscor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int tc = reader.nextInt();
        StringBuilder buf = new StringBuilder();
        while (tc-- > 0) {
            int n = reader.nextInt();
            int k = reader.nextInt();
            int[] value = new int[n];
            int[] time = new int[n];
            for (int i = 0; i < n; i++) {
                value[i] = reader.nextInt();
                time[i] = reader.nextInt();
            }
            long res = solve(k, value, time);
            buf.append(res);
            buf.append('\n');
        }
        System.out.print(buf.toString());
    }

    public static final long solve(int k, int[] value, int[] time) {
        long[][] dp = new long[2][k + 1];
        for (int j = 0; j <= k; j++) {
            dp[1][j] = -(1 << 30);
        }
        for (int i = 0; i < value.length; i++) {
            int t = time[i];
            for (int j = k - t; j >= 0; j--) {
                dp[0][j + t] = Math.max(dp[0][j + t], dp[0][j] + value[i]);
                dp[1][j + t] = Math.max(dp[1][j + t], Math.max(dp[1][j] + value[i], dp[0][j]));
            }
        }
        return dp[1][k];
    }
}
