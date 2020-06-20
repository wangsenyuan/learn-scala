package codechef.medium.qtragain;

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
            int q = reader.nextInt();
            for (int i = 0; i < n - 1; i++) {
                E[i][0] = reader.nextInt();
                E[i][1] = reader.nextInt();
            }
            Solver solver = new Solver(n, E);

            while (q-- > 0) {
                int t = reader.nextInt();
                int x = reader.nextInt();
                if (t == 1) {
                    int y = reader.nextInt();
                    solver.update(x, y);
                } else {
                    System.out.println(solver.get(x));
                }
            }
        }
    }

    private static final int MAX_N = 100010;
    private static final int MAX_H = 63;
    private static final int MOD = 1000000007;
    private static final long[] POW = new long[MAX_H];
    private static final int[][] E = new int[MAX_N][2];

    static {
        POW[0] = 1;
        for (int i = 1; i < MAX_H; i++) {
            POW[i] = 2 * POW[i - 1];
            POW[i] %= MOD;
        }
    }


    private static class Solver {
        private static long[] value = new long[MAX_N];
        private static long[][] lazy = new long[MAX_N][MAX_H];
        private static int[] parent = new int[MAX_N];
        private static int[] degree = new int[MAX_N];
        private static int[][] adj = new int[MAX_N][];

        public Solver(int n, int[][] E) {
            for (int i = 0; i <= n; i++) {
                value[i] = 0;
                for (int j = 0; j < MAX_H; j++) {
                    lazy[i][j] = 0;
                }
                degree[i] = 0;
            }

            for (int i = 0; i < n - 1; i++) {
                int u = E[i][0];
                int v = E[i][1];
                degree[u]++;
                degree[v]++;
            }

            for (int i = 0; i <= n; i++) {
                adj[i] = new int[degree[i]];
            }

            for (int i = 0; i < n - 1; i++) {
                int u = E[i][0];
                int v = E[i][1];
                adj[u][--degree[u]] = v;
                adj[v][--degree[v]] = u;
            }

            dfs(-1, 1);
        }

        private void dfs(int p, int x) {
            parent[x] = p;

            for (int i = 0; i < adj[x].length; i++) {
                if (adj[x][i] == p) {
                    continue;
                }
                dfs(x, adj[x][i]);
            }
        }

        public void update(int x, int y) {
            int px = x;
            int py = y;

            while (px > 0 && py >= 0) {
                value[px] += POW[py];
                value[px] %= MOD;
                px = parent[px];
                py--;
            }

            for (int d = 1; d <= y; d++) {
                lazy[x][d] += POW[y - d];
                lazy[x][d] %= MOD;
            }
        }

        public int get(int x) {
            long res = value[x];

            int px = parent[x];
            int py = 1;
            while (px > 0 && py < MAX_H) {
                res += lazy[px][py];
                res %= MOD;
                px = parent[px];
                py++;
            }
            return (int) res;
        }
    }
}
