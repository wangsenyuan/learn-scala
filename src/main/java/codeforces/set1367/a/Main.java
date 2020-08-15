package codeforces.set1367.a;

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
            System.out.println(solve(s));
        }
    }

    private static String solve(String s) {
        int n = s.length();
        char[] a = new char[n / 2 + 1];
        for (int i = 0; i < n; i += 2) {
            a[i / 2] = s.charAt(i);
        }
        a[n / 2] = s.charAt(n - 1);

        return new String(a);
    }
}
