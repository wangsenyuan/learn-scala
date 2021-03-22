package codeforces.set1486.a;

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
            int n = reader.nextInt();
            long expect = 0;
            long sum = 0;
            boolean can = true;
            for (int i = 0; i < n; i++) {
                expect += i;
                sum += reader.nextInt();
                if (can && sum < expect) {
                    can = false;
                }
            }
            if (can) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
