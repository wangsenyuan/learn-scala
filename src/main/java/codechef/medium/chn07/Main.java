package codechef.medium.chn07;

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
        StringBuilder buf = new StringBuilder();
        int tc = reader.nextInt();
        while (tc-- > 0) {
            String s = reader.next();
            boolean res = solve(s);
            if (res) {
                buf.append("Malvika\n");
            } else {
                buf.append("Animesh\n");
            }
        }
        System.out.print(buf);
    }

    //    private static boolean solve(String s) {
    //        int n = s.length();
    //        boolean[] dp = new boolean[n + 1];
    //        for (int i = n - 1; i >= 0; i--) {
    //            if (s.charAt(i) == 'R') {
    //                dp[i] = !dp[i + 1];
    //                if (!dp[i] && i + 1 < n && s.charAt(i + 1) == 'B') {
    //                    dp[i] = dp[i + 2];
    //                }
    //            } else {
    //                dp[i] = dp[i + 1];
    //            }
    //        }
    //        return dp[0];
    //    }

    private static boolean solve(String s) {
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                cur = (cur * 2 + 1) % 3;
            } else {
                cur = (cur * 2) % 3;
            }
        }
        return cur > 0;
    }

}
