package set1000.set1100.set1190.p1192;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionJ {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] outs = new List[n];
        for (int i = 0; i < n; i++) {
            outs[i] = new ArrayList<>();
        }

        for (List<Integer> conn : connections) {
            int a = conn.get(0);
            int b = conn.get(1);
            outs[a].add(b);
            outs[b].add(a);
        }

        this.dp = new int[n];
        this.low = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }
        this.time = 0;
        List<List<Integer>> res = new ArrayList<>();
        dfs(outs, -1, 0, res);

        return res;
    }

    private int time;
    private int[] dp;
    private int[] low;

    private void dfs(List<Integer>[] outs, int p, int u, List<List<Integer>> res) {
        if (dp[u] >= 0) {
            return;
        }
        this.dp[u] = time;
        this.low[u] = time;
        this.time++;

        for (Integer v : outs[u]) {
            if (p == v) {
                continue;
            }

            dfs(outs, u, v, res);

            if (low[v] > dp[u]) {
                res.add(Arrays.asList(u, v));
            }
            low[u] = Math.min(low[u], low[v]);
        }
    }
}
