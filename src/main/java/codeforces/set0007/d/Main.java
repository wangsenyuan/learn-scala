package codeforces.set0007.d;

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
    }

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        String s = reader.next();
        System.out.println(solve(s));
    }

    private static long solve(String s) {
        int[] p = manachers(s);

        int n = s.length();

        long[] dp = new long[n];
        dp[0] = 1;
        long res = 1;

        for (int i = 2; i <= n; i++) {
            if (p[i - 1] == 0) {
                dp[i - 1] = 1;
                //prefix s[0..i] is palindrome
                if (p[i / 2 - 1] == 0) {
                    dp[i - 1] += dp[i / 2 - 1];
                }
                res += dp[i - 1];
            }
        }

        return res;
    }

    public static int[] manachers(String s) {
        String ss = modify(s);
        int n = ss.length();
        int[] P = new int[n];
        int c = 0, r = 0;

        for (int i = 0; i < n; i++) {
            int mirror = 2 * c - r;

            if (i < r) {
                P[i] = Math.min(r - i, P[mirror]);
            }
            int a = i + 1 + P[i];
            int b = i - (1 + P[i]);
            while (a < n && b >= 0 && ss.charAt(a) == ss.charAt(b)) {
                P[i]++;
                a++;
                b--;
            }

            if (i + P[i] > r) {
                r = i + P[i];
                c = i;
            }
        }
        int[] f = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            f[i] = i;
        }
        for (int i = 0; i < n; i++) {
            //l := P[i]
            // #a#a#b#
            int a = i + P[i];
            int b = i - P[i];
            a--;
            b++;
            if (a > b || i % 2 != 0) {
                f[a / 2] = Math.min(f[a / 2], b / 2);
            }
        }
        return f;
    }


    private static String modify(String s) {
        StringBuilder buf = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            buf.append('#');
            buf.append(s.charAt(i));
        }
        buf.append('#');
        return buf.toString();
    }

}
