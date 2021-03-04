package codeforces.set1476.d;

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
            solve(reader);
        }
    }

    private static void solve(FastReader reader) {
        int n = reader.nextInt();
        String s = reader.next();
        int a = 0;
        int b = 0;
        int[] res = new int[n + 1];

        for (int i = 0; i < n; i++) {
            char x = s.charAt(i);
            if (x == 'L') {
                b = a + 1;
                a = 0;
                res[i + 1] = b;
            } else {
                a = b + 1;
                b = 0;
            }
        }
        a = 0;
        b = 0;
        for (int i = n - 1; i >= 0; i--) {
            char x = s.charAt(i);
            if (x == 'R') {
                b = a + 1;
                a = 0;
                res[i] += b;
            } else {
                a = b + 1;
                b = 0;
            }
        }
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            buf.append(res[i] + 1);
            buf.append(' ');
        }
        System.out.println(buf.toString());
    }
}
