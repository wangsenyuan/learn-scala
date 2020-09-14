package codeforces.set1373.b;

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

        int tc = reader.nextInt();
        while (tc-- > 0) {
            String s = reader.next();
            boolean res = solve(s);
            if (res) {
                System.out.println("DA");
            } else {
                System.out.println("NET");
            }
        }
    }

    private static boolean solve(String s) {
        int cnt1 = 0;

        for (int i = 0; i < s.length(); i++) {
            cnt1 += s.charAt(i) - '0';
        }
        int cnt0 = s.length() - cnt1;
        int cnt = Math.min(cnt0, cnt1);

        return (cnt & 1) == 1;
    }
}
