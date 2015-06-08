package geeks.lca;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by senyuanwang on 15/6/8.
 */
public class Tree {
    private List<Integer>[] g;
    private int size, root;
    private boolean inited;
    private int[] depth;

    public Tree(int size, int root) {
        this.size = size;
        g = new List[size];
        this.depth = new int[size];
        for(int i = 0; i < size; i++) {
            g[i] = new ArrayList<>();
        }
//        this.parent = new int[size];
        this.root = root;
    }

    public Tree(int size) {
        this(size, 0);
    }

    public void addEdge(int parent, int child) {
        assert (parent < size);
        g[parent].add(child);
    }


    private void dfs(int v, int p, int d, int[] parent) {
        parent[v] = p;
        depth[v] = d;
        for (int i = 0; i < g[v].size(); i++) {
            int w = g[v].get(i);
            if (w != p) {
                dfs(w, v, d + 1, parent);
            }
        }
    }

    public int lca0(int u, int v) {
        int[] parent = new int[size];
        dfs(root, -1, 0, parent);

        while (depth[u] > depth[v]) {
            u = parent[u];
        }

        while (depth[v] > depth[u]) {
            v = parent[v];
        }

        while (u != v) {
            u = parent[u];
            v = parent[v];
        }
        return u;
    }

    public int lca1(int u, int v) {
        int logV = (int) Math.log(size) + 1;
        int[][] parent = new int[logV][size];

        dfs(root, -1, 0, parent[0]);

        for (int k = 0; k + 1 < logV; k++) {
            for (int x = 0; x < size; x++) {
                if (parent[k][x] < 0) {
                    parent[k + 1][x] = -1;
                } else {
                    parent[k + 1][x] = parent[k][parent[k][x]];
                }
            }
        }

        if (depth[u] > depth[v]) {
            int tmp = u;
            u = v;
            v = tmp;
        }

        for (int k = 0; k < logV; k++) {
            if (((depth[v] - depth[u]) >> k & 1) == 1) {
                v = parent[k][v];
            }
        }

        if (u == v) {
            return u;
        }

        for (int k = logV - 1; k >= 0; k--) {
            if (parent[k][u] != parent[k][v]) {
                u = parent[k][u];
                v = parent[k][v];
            }
        }
        return parent[0][u];
    }
}
