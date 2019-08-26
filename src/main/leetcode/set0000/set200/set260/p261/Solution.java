package set0000.set200.set260.p261;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by senyuanwang on 15/8/18.
 */
public class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<Integer>[] list = new List[n];

        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            if (list[a] == null) {
                list[a] = new ArrayList<>();
            }
            list[a].add(b);
            if (list[b] == null) {
                list[b] = new ArrayList<>();
            }
            list[b].add(a);
        }

        boolean[] visited = new boolean[n];
        try {
            traveral(-1, 0, list, visited);

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    return false;
                }
            }
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    private void traveral(int p, int x, List<Integer>[] edges, boolean[] visited) {
        visited[x] = true;
        List<Integer> adj = edges[x];
        if (adj == null) {
            return;
        }
        for (int y : adj) {
            if(y == p) {
                continue;
            }
            if (visited[y]) {
                throw new RuntimeException("not tree");
            }
            traveral(x, y, edges, visited);
        }
    }


}
