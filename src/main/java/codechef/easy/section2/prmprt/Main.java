package codechef.easy.section2.prmprt;

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
    }

    public static void main(String[] args) {
        init();
        FastReader reader = new FastReader();
        int n = reader.nextInt();
        int m = reader.nextInt();

        for (int i = 0; i < m; i++) {
            int u = reader.nextInt();
            int v = reader.nextInt();
            System.out.println(solve(n, u, v));
        }
    }

    private static final int MAX_N = 1000007;
    private static int[] factors = new int[MAX_N];

    private static void init() {
        boolean[] set = new boolean[MAX_N];

        for (int x = 2; x < MAX_N; x++) {
            if (!set[x]) {
                factors[x] = x;
                long y = 1l * x * x;
                while (y < MAX_N) {
                    if (factors[(int) y] == 0) {
                        factors[(int) y] = x;
                    }
                    set[(int) y] = true;

                    y += x;
                }
            }
        }
    }

    private static int solve(int n, int u, int v) {
        if (u == 1 || v == 1) {
            return -1;
        }
        if (u == v) {
            return 0;
        }

        int x = factors[u];
        int y = factors[v];

        int r = 0;

        if (x != y) {
            long m = 1l * x * y;
            if (m > n) {
                return -1;
            }
            r = 2;
        }

        if (factors[u] != u) {
            r++;
        }
        if (factors[v] != v) {
            r++;
        }
        return r;
    }
}
