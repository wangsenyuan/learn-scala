package codechef.easy.section1.zubapcnt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
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
    }

    final static long MOD = 1000000007;

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int t = reader.nextInt();
        for (int x = 1; x <= t; x++) {
            int n = reader.nextInt();
            int m = reader.nextInt();
            System.out.printf("Case %d:\n", x);
            for (int i = 0; i < m; i++) {
                String s = reader.next();
                if (s.length() > n) {
                    System.out.println(0);
                } else {
                    long ans = power(26, n - s.length());
                    ans = (ans * (n - s.length() + 1)) % MOD;
                    System.out.println(ans);
                }
            }
        }
    }

    public static long power(int a, int b) {
        long x = 1;
        long y = a;
        while (b > 0) {
            if ((b & 1) == 1) {
                x = (x * y) % MOD;
            }
            y = (y * y) % MOD;
            b >>= 1;
        }
        return x;
    }
}
