package set400.set400.p407;

import java.util.*;

/**
 * Created by wangsenyuan on 9/25/16.
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        //int[][] height = {{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}};
        //int[][] height = {{5, 5, 5, 1}, {5, 1, 1, 5}, {5, 1, 5, 5}, {5, 2, 5, 8}};
        int[][] height = {{12, 13, 1, 12}, {13, 4, 13, 12}, {13, 8, 10, 12}, {12, 13, 12, 12}, {13, 13, 13, 13}};
        System.out.println(solution1.trapRainWater(height));
    }

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    private int[] dijkstra(List<int[]>[] g, int start) {
        int[] dist = new int[g.length];
        Arrays.fill(dist, Integer.MAX_VALUE / 2);
        dist[start] = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((u, v) -> u[1] == v[1] ? u[0] - v[0] : u[1] - v[1]);
        queue.add(new int[]{start, 0});
        boolean[] checked = new boolean[g.length];
        while (!queue.isEmpty()) {
            int[] first = queue.poll();
            int u = first[0], d = first[1];
            checked[u] = true;
            for (int[] e : g[u]) {
                int v = e[0], w = e[1];
                if (checked[v]) {
                    continue;
                }
                int x = Math.max(d, w);
                if (x < dist[v]) {
                    dist[v] = x;
                    queue.offer(new int[]{v, dist[v]});
                }
            }
        }
        return dist;
    }

    public int trapRainWater(int[][] a) {
        if (a == null || a.length == 0 || a[0].length == 0) return 0;
        int r = a.length, c = a[0].length;

        int start = r * c;
        List<int[]>[] g = new List[r * c + 1];
        for (int i = 0; i < g.length; i++) g[i] = new ArrayList<>();
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++) {
                if (i == 0 || i == r - 1 || j == 0 || j == c - 1) {
                    g[start].add(new int[]{i * c + j, 0});
                }
                for (int k = 0; k < 4; k++) {
                    int x = i + dx[k], y = j + dy[k];
                    if (x >= 0 && x < r && y >= 0 && y < c) {
                        g[i * c + j].add(new int[]{x * c + y, a[i][j]});
                    }
                }
            }

        int ans = 0;
        int[] dist = dijkstra(g, start);
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++) {
                int cb = dist[i * c + j];
                if (cb > a[i][j]) ans += cb - a[i][j];
            }

        return ans;
    }
}
