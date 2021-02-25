package codechef.medium.gamofnum;

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


    private static final int MAX_X = 500010;

    private static int[] factors = new int[MAX_X];
    private static int[] ans = new int[MAX_X];

    private static void sieve() {
        int cnt = 0;
        factors[1] = 1;
        for (int x = 2; x < MAX_X; x++) {
            if (factors[x] == 0) {
                ans[x] = ++cnt;
                for (int j = x; j < MAX_X; j += x) {
                    factors[j] = x;
                }
            }
        }
    }

    public static void main(String[] args) {
        sieve();
        FastReader reader = new FastReader();
        int tc = reader.nextInt();
        while (tc-- > 0) {
            int n = reader.nextInt();
            int res = 0;
            while (n-- > 0) {
                int a = reader.nextInt();
                while (a > 1) {
                    res ^= ans[factors[a]];
                    a /= factors[a];
                }
            }
            if (res != 0) {
                System.out.println("Alice");
            } else {
                System.out.println("Bob");
            }
        }
    }
}
