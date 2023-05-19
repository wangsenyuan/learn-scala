package codechef.easy.section2.convair;

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
            int[][] E = new int[m][2];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < 2; j++) {
                    E[i][j] = reader.nextInt();
                }
            }
            solve(n, E);
        }
    }

    public static void solve(int n, int[][] E) {
        UF set = new UF(n);

        List<int[]> ext = new ArrayList<>();
        List<int[]> use = new ArrayList<>();
        int[] deg = new int[n];
        for (int j = 0; j < E.length; j++) {
            int[] e = E[j];
            for (int i = 0; i < e.length; i++) {
                e[i]--;
            }
            int u = e[0];
            int v = e[1];
            deg[u]++;
            deg[v]++;
            if (set.union(u, v)) {
                use.add(e);
            } else {
                ext.add(e);
            }
        }
        if (ext.size() > 1) {
            int[] first = ext.get(0);
            List<int[]> tmp = new ArrayList<>();
            for (int i = 1; i < ext.size(); i++) {
                int a = first[0];
                int b = first[1];
                int[] cur = ext.get(i);
                int c = cur[0];
                int d = cur[1];
                if (set.union(a, c)) {
                    use.add(new int[] {b, d});
                    first[1] = c;
                } else {
                    tmp.add(cur);
                }
            }
            tmp.add(first);
            ext = tmp;
        }

        int[] edgeCount = new int[n];
        Set<Integer>[] nodes = new HashSet[n];
        int[] edge = new int[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new HashSet<>();
            edge[i] = -1;
        }
        for (int i = 0; i < use.size(); i++) {
            int[] e = use.get(i);
            int u = e[0];
            int v = e[1];
            int p = set.find(u);
            nodes[p].add(u);
            nodes[p].add(v);
            edgeCount[p]++;
            edge[u] = i;
            edge[v] = i;
        }

        for (int i = 0; i < ext.size(); i++) {
            int[] e = ext.get(i);
            int u = e[0];
            int v = e[1];
            int p = set.find(u);
            nodes[p].add(u);
            nodes[p].add(v);
            edgeCount[p]++;
        }

        List<Integer> trees = new ArrayList<>();
        List<Integer> ports = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int j = set.find(i);
            if (edgeCount[j] + 1 == nodes[j].size()) {
                // a tree
                trees.add(edge[i]);
                edgeCount[j]++;
            }
            if (i == j && nodes[j].size() == 0) {
                ports.add(i);
            }
        }
        boolean[] rem = new boolean[use.size()];
        int p = 0;
        for (; p < ext.size() && p < trees.size(); p++) {
            int[] cur = ext.get(p);
            int j = trees.get(p);
            rem[j] = true;
            int[] tmp = use.get(j);
            int a = cur[0];
            int b = cur[1];
            int c = tmp[0];
            int d = tmp[1];
            set.union(a, c);
            use.add(new int[] {a, c});
            use.add(new int[] {b, d});
        }

        for (int i = 0; i + 1 < ports.size() && p < ext.size(); i += 2, p++) {
            int[] cur = ext.get(p);
            int a = cur[0];
            int b = cur[1];
            int c = ports.get(i);
            int d = ports.get(i + 1);
            use.add(new int[] {a, c});
            use.add(new int[] {b, d});
            set.union(a, c);
            set.union(b, d);
        }

        List<Integer> roots = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int j = set.find(i);
            if (i == j) {
                roots.add(i);
            }
        }

        for (int i = 1; i < roots.size(); i++) {
            use.add(new int[] {roots.get(i - 1), roots.get(i)});
            set.union(roots.get(i - 1), roots.get(i));
        }

        List<int[]> res = new ArrayList<>();
        int[] deg2 = new int[n];
        for (int i = 0; i < use.size(); i++) {
            if (i < rem.length && rem[i]) {
                continue;
            }
            int[] cur = use.get(i);
            int u = cur[0];
            int v = cur[1];
            res.add(cur);
            deg2[u]++;
            deg2[v]++;
        }
        int cost = 0;
        for (int i = 0; i < n; i++) {
            cost += Math.abs(deg[i] - deg2[i]);
        }

        System.out.printf("%d %d\n", cost, res.size());
        for (int i = 0; i < res.size(); i++) {
            int[] cur = res.get(i);
            System.out.printf("%d %d\n", cur[0] + 1, cur[1] + 1);
        }
    }


    static class UF {
        private final int[] array;
        private final int[] count;
        private int size;

        public UF(int sz) {
            this.array = new int[sz];
            this.count = new int[sz];
            for (int i = 0; i < sz; i++) {
                array[i] = i;
                count[i]++;
            }
            this.size = sz;
        }

        public int find(int x) {
            int p = this.array[x];
            if (p == x) {
                return x;
            }
            this.array[x] = find(p);
            return this.array[x];
        }

        public boolean union(int x, int y) {
            int a = find(x);
            int b = find(y);
            if (a == b) {
                return false;
            }
            if (count[a] < count[b]) {
                a = a ^ b;
                b = a ^ b;
                a = a ^ b;
            }
            count[a] += count[b];
            array[b] = a;
            size--;
            return true;
        }
    }
}
