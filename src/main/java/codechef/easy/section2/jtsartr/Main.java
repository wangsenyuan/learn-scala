package codechef.easy.section2.jtsartr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

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
        FastReader reader = new FastReader();
        int tc = reader.nextInt();

        while (tc-- > 0) {
            int n = reader.nextInt();
            int[] V = new int[n];
            for (int i = 0; i < n; i++) {
                V[i] = reader.nextInt();
            }
            int[][] E = new int[n - 1][];
            for (int i = 0; i < n - 1; i++) {
                E[i] = new int[2];
                E[i][0] = reader.nextInt();
                E[i][1] = reader.nextInt();
            }
            System.out.println(solve(n, E, V));
        }
    }

    private static int[][] getGraph(int n, int[][] E) {
        int[] degree = new int[n];
        for (int[] e : E) {
            int u = e[0];
            int v = e[1];
            degree[u - 1]++;
            degree[v - 1]++;
        }

        int[][] G = new int[n][];
        for (int i = 0; i < n; i++) {
            G[i] = new int[degree[i]];
        }

        for (int[] e : E) {
            int u = e[0] - 1;
            int v = e[1] - 1;
            G[u][--degree[u]] = v;
            G[v][--degree[v]] = u;
        }

        return G;
    }

    public static int solve(int n, int[][] E, int[] V) {
        int[][] g = getGraph(n, E);
        int[] dp = new int[n];
        int[] ll = new int[n];
        TreeMap<Integer, Integer> pos = new TreeMap<>();

        dfs(-1, 0, g, V, pos, dp, ll);

        int res = 1;

        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    private static void dfs(int p, int u, int[][] G, int[] V, TreeMap<Integer, Integer> pos, int[] dp, int[] ll) {
        if (p >= 0 && V[u] >= V[p]) {
            dp[u] = dp[p] + 1;
            ll[u] = ll[p] + 1;
        } else {
            dp[u] = 0;
            ll[u] = 1;
        }
        Map.Entry<Integer, Integer> prev = pos.floorEntry(V[u]);
        if (prev != null) {
            dp[u] = Math.max(dp[u], prev.getValue() + 1);
        }

        Integer before = pos.get(V[u]);

        if (before == null || before < ll[u]) {
            pos.put(V[u], ll[u]);
        }

        for (int i = 0; i < G[u].length; i++) {
            if (G[u][i] == p) {
                continue;
            }
            dfs(u, G[u][i], G, V, pos, dp, ll);
        }

        if (before == null) {
            pos.remove(V[u]);
        } else {
            pos.put(V[u], before);
        }
    }
}
