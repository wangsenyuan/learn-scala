package codechef.medium.searrays;

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

        int t = reader.nextInt();

        int MOD = 1000000007;
        while (t-- > 0) {
            int n = reader.nextInt();
            int k = reader.nextInt();

            long[] f = new long[n + 1];
            f[0] = 1;
            for (int i = 1; i <= n; i++) {
                f[i] = f[i - 1];
                if (i - k >= 0) {
                    f[i] = (f[i] + f[i - k]) % MOD;
                }
            }
            System.out.println(f[n]);
        }

    }
}
