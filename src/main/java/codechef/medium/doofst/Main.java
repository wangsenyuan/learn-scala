package codechef.medium.doofst;

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
    }

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        StringBuilder buf = new StringBuilder();
        int n = reader.nextInt();
        int m = reader.nextInt();
        int[][] E = new int[m][2];
        for (int i = 0; i < m; i++) {
            E[i][0] = reader.nextInt();
            E[i][1] = reader.nextInt();
        }
        List<String> res = solve(n, E);
        if (res == null) {
            System.out.println("-1");
            return;
        }
        buf.append(res.size());
        buf.append('\n');
        for (String x : res) {
            buf.append(x);
            buf.append('\n');
        }
        System.out.print(buf.toString());
    }

    private static List<String> solve(int n, int[][] E) {
        Set<Integer>[] adj = new HashSet[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new HashSet<>();
        }
        for (int[] e : E) {
            int u = e[0] - 1;
            int v = e[1] - 1;
            adj[u].add(v);
            adj[v].add(u);
        }

        TreeSet<Integer> rem = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            rem.add(i);
        }
        long tot = 1l * n * (n - 1) / 2;
        int[] C = new int[n];
        int cur = 0;
        for (int i = 0; i < n; i++) {
            if (rem.contains(i)) {
                //                rem.remove(i);
                int cnt = dfs(i, adj, rem, C, cur);
                cur++;
                tot -= 1l * cnt * (cnt - 1) / 2;
            }
        }

        if (tot != E.length) {
            return null;
        }

        for (int u = 0; u < n; u++) {
            for (Integer v : adj[u]) {
                if (C[u] == C[v]) {
                    return null;
                }
            }
        }

        List<Integer>[] V = new List[cur];

        for (int i = 0; i < cur; i++) {
            V[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            V[C[i]].add(i);
        }

        byte[][] res = new byte[11][n];

        for (int i = 0; i < 11; i++) {
            res[i] = new byte[n];
            for (int j = 0; j < n; j++) {
                res[i][j] = '0';
            }
        }

        int h = divide(0, 0, cur - 1, V, res);

        List<String> ans = new ArrayList<>(h);
        for (int i = 0; i < h; i++) {
            ans.add(new String(res[i]));
        }
        return ans;
    }

    private static int divide(int h, int l, int r, List<Integer>[] V, byte[][] res) {
        if (l == r) {
            return h;
        }
        int md = (l + r) / 2;
        for (int i = l; i <= md; i++) {
            for (int j : V[i]) {
                res[h][j] = '1';
            }
        }
        int a = divide(h + 1, l, md, V, res);
        int b = divide(h + 1, md + 1, r, V, res);
        return Math.max(a, b);
    }

    private static int dfs(int u, Set<Integer>[] adj, TreeSet<Integer> rem, int[] C, int cur) {
        C[u] = cur;
        rem.remove(u);
        int cnt = 0;
        int n = adj.length;
        if (rem.size() > 0) {
            int v = rem.first();
            while (v < n) {
                Integer w = rem.ceiling(v);
                if (w == null) {
                    break;
                }
                if (!adj[u].contains(w)) {
                    //                rem.remove(w);
                    cnt += dfs(w, adj, rem, C, cur);
                }
                v = w + 1;
            }
        }

        return cnt + 1;
    }
}
