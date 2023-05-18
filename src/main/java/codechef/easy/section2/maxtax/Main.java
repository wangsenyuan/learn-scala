package codechef.easy.section2.maxtax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
            int m = reader.nextInt();
            int k = reader.nextInt();
            int[] B = new int[n];
            for (int i = 0; i < n; i++) {
                B[i] = reader.nextInt();
            }
            int[][] E = new int[m][2];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < 2; j++) {
                    E[i][j] = reader.nextInt();
                }
            }
            long res = solve(n, k, E, B);
            System.out.println(res);
        }
    }

    private static int[][] getGraph(int n, int[][] E, boolean rev) {
        int[][] g = new int[n][n + 1];

        for (int[] e : E) {
            int u = e[0] - 1;
            int v = e[1] - 1;
            if (rev) {
                g[v][g[v][n]++] = u;
            } else {
                g[u][g[u][n]++] = v;
            }
        }
        return g;
    }


    public static long solve(int n, int k, int[][] E, int[] B) {
        int[][] g = getGraph(n, E, false);
        int[][] rg = getGraph(n, E, true);

        boolean[] vis = new boolean[n];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(g, i, s, vis);
            }
        }

        Arrays.fill(vis, false);

        int[] comps = new int[n];
        int[][] vals = new int[n][];
        int id = 0;
        while (!s.isEmpty()) {
            int u = s.pop();
            if (!vis[u]) {
                Set<Integer> set = new HashSet<>();
                dfs1(rg, u, set, vis);
                int[] cur = new int[set.size()];
                int i = 0;
                for (int v : set) {
                    cur[i++] = B[v];
                    comps[v] = id;
                }
                Arrays.sort(cur);
                vals[id] = cur;
                id++;
            }
        }

        int[][] ng = new int[id][id + 1];
        TreeSet<Integer>[] sets = new TreeSet[id];
        for (int i = 0; i < id; i++) {
            sets[i] = new TreeSet<>();
        }
        for (int[] e : E) {
            int u = comps[e[0] - 1];
            int v = comps[e[1] - 1];
            if (u != v && !sets[u].contains(v)) {
                ng[u][ng[u][id]++] = v;
                sets[u].add(v);
            }
        }

        Arrays.fill(vis, false);

        for (int i = 0; i < id; i++) {
            if (!vis[i]) {
                dfs(ng, i, s, vis);
            }
        }

        Stack<Integer> list = new Stack<>();
        while (!s.isEmpty()) {
            list.push(s.pop());
        }

        long[][] dp = new long[id][k + 1];

        long[] tmp = new long[k + 1];
        long ans = 0;

        while (!list.isEmpty()) {
            int u = list.pop();
            for (int i = 0; i < ng[u][id]; i++) {
                int v = ng[u][i];
                for (int j = 0; j <= k; j++) {
                    tmp[j] = Math.max(tmp[j], dp[v][j]);
                }
            }

            int[] cur = vals[u];

            for (int j = 0; j <= k; j++) {
                for (int i = 0; i <= j && i < cur.length; i++) {
                    dp[u][j] = Math.max(dp[u][j], tmp[j - i] + (long) cur[i] * (cur.length - i));
                }
                ans = Math.max(ans, dp[u][j]);
            }

            Arrays.fill(tmp, 0);
        }

        return (ans % 1000000021);
    }

    private static void dfs(int[][] g, int u, Stack<Integer> stack, boolean[] vis) {
        vis[u] = true;
        int n = g.length;
        for (int i = 0; i < g[u][n]; i++) {
            int v = g[u][i];
            if (!vis[v]) {
                dfs(g, v, stack, vis);
            }
        }
        stack.push(u);
    }

    private static void dfs1(int[][] g, int u, Set<Integer> set, boolean[] vis) {
        vis[u] = true;
        set.add(u);
        int n = g.length;
        for (int i = 0; i < g[u][n]; i++) {
            int v = g[u][i];
            if (!vis[v]) {
                dfs1(g, v, set, vis);
            }
        }
    }
}
