package p310;

import java.util.*;

/**
 * Created by senyuanwang on 2016/10/26.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        solution.findMinHeightTrees(6, edges).forEach(System.out::println);
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n < 2) {
            return Arrays.asList(0);
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            graph.putIfAbsent(a, new ArrayList<>());
            graph.get(a).add(b);

            graph.putIfAbsent(b, new ArrayList<>());
            graph.get(b).add(a);
        }

        Map<Integer, Integer>[] height = new Map[n];
        for (int i = 0; i < n; i++) {
            height[i] = new HashMap<>();
        }
        dfs(-1, 0, graph, height);

        for (int w : graph.get(0)) {
            int h = 1;
            for (int x : height[0].keySet()) {
                if (x == w) {
                    continue;
                }
                if (height[0].get(x) > h) {
                    h = height[0].get(x);
                }
            }
            updateHeight(0, w, h + 1, graph, height);
        }

        int minHeight = Integer.MAX_VALUE;

        for (Map<Integer, Integer> h : height) {
            int maxHeight = 0;
            for (int x : h.values()) {
                if (x > maxHeight) {
                    maxHeight = x;
                }
            }
            if (maxHeight < minHeight) {
                minHeight = maxHeight;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> h = height[i];
            int maxHeight = 0;
            for (int x : h.values()) {
                if (x > maxHeight) {
                    maxHeight = x;
                }
            }
            if (maxHeight == minHeight) {
                result.add(i);
            }
        }
        return result;
    }

    private int dfs(int p, int v, Map<Integer, List<Integer>> graph, Map<Integer, Integer>[] height) {
        int h = 1;

        for (int w : graph.get(v)) {
            if (w == p) {
                continue;
            }
            int wh = dfs(v, w, graph, height);
            height[v].put(w, wh);
            if (wh > h) {
                h = wh;
            }
        }
        return h + 1;
    }

    private void updateHeight(int v, int w, int h, Map<Integer, List<Integer>> graph, Map<Integer, Integer>[] height) {
        height[w].put(v, h);

        for (int y : graph.get(w)) {
            if (y == v) {
                continue;
            }
            int hh = h;
            for (int x : height[w].keySet()) {
                if (y == x) {
                    continue;
                }
                if (height[w].get(x) > hh) {
                    hh = height[w].get(x);
                }
            }
            updateHeight(w, y, hh + 1, graph, height);
        }
    }

}
