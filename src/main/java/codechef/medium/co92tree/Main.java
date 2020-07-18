package codechef.medium.co92tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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


    private final static int N = 100010;
    private static ArrayList<Integer>[] conn;
    private static int[] set;
    private static int[] cnt;
    private static int[] parent;

    public static void main(String[] args) {
        conn = new ArrayList[N];
        set = new int[N];
        cnt = new int[N];
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            conn[i] = new ArrayList<>();
            set[i] = i;
            cnt[i] = 1;
        }

        FastReader reader = new FastReader();

        int tc = reader.nextInt();

        while (tc-- > 0) {
            int n = reader.nextInt();
            for (int i = 0; i <= n; i++) {
                conn[i].clear();
            }

            for (int i = 0; i < n - 1; i++) {
                int u = reader.nextInt();
                int v = reader.nextInt();
                conn[u].add(v);
                conn[v].add(u);
            }

            System.out.println(solve(n, conn));
        }
    }

    private static int find(int x) {
        if (set[x] == x) {
            return x;
        }
        return set[x] = find(set[x]);
    }

    private static boolean union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv) {
            return false;
        }
        if (cnt[pu] < cnt[pv]) {
            pu = pu ^ pv;
            pv = pu ^ pv;
            pu = pu ^ pv;
        }

        set[pv] = pu;
        cnt[pu] += cnt[pv];
        return true;
    }

    private static void dfs(ArrayList<Integer>[] conn, int p, int u) {
        parent[u] = p;

        for (int v : conn[u]) {
            if (p == v) {
                continue;
            }
            dfs(conn, u, v);
        }
    }

    private static long solve(int n, ArrayList<Integer>[] conn) {
        dfs(conn, 1, 1);
        long best = n;
        for (int u = 1; u <= n; u++) {
            int size = 1;
            for (int v = u; v <= n; v = (v + 1) | u) {
                int w = parent[v];
                if ((w & u) != u || !union(v, w)) {
                    continue;
                }
                size = Math.max(size, cnt[find(w)]);
            }

            long tmp = 1L * size * u;
            best = Math.max(best, tmp);

            for (int v = u; v <= n; v = (v + 1) | u) {
                set[v] = v;
                cnt[v] = 1;
            }
        }

        return best;
    }
}
