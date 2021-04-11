package codeforces.set920.e;

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
        List<Integer> res = solve(n, E);
        buf.append(res.size());
        buf.append('\n');
        for (Integer x : res) {
            buf.append(x);
            buf.append(' ');
        }
        buf.append('\n');
        System.out.print(buf.toString());
    }

    private static List<Integer> solve(int n, int[][] E) {
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
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (rem.contains(i)) {
                //                rem.remove(i);
                res.add(dfs(i, adj, rem));
            }
        }
        Collections.sort(res);
        return res;
    }

    private static int dfs(int u, Set<Integer>[] adj, TreeSet<Integer> rem) {
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
                    cnt += dfs(w, adj, rem);
                }
                v = w + 1;
            }
        }

        return cnt + 1;
    }
}
