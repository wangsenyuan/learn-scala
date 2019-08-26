package set0000.set300.set310.p310;

import java.util.*;

/**
 * Created by senyuanwang on 2016/10/26.
 */
public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        //int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
        //int[][] edges = {{1, 0}, {1, 2}, {1, 3}};
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {3, 4}, {4, 5}};
        solution1.findMinHeightTrees(6, edges).forEach(System.out::println);
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n < 2) {
            return Arrays.asList(0);
        }

        List<Integer>[] graph = new List[n];
        int[] degree = new int[n];
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            if (graph[a] == null) {
                graph[a] = new ArrayList<>();
            }
            graph[a].add(b);
            degree[a]++;
            if (graph[b] == null) {
                graph[b] = new ArrayList<>();
            }
            graph[b].add(a);
            degree[b]++;
        }

        List<Integer> current = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                current.add(i);
            }
        }

        int left = n;
        while (left > 2) {
            List<Integer> next = new ArrayList<>(left);
            for (Integer x : current) {
                left--;
                for (int y : graph[x]) {
                    graph[y].remove(x);
                    degree[y]--;
                    if (degree[y] == 1) {
                        next.add(y);
                    }
                }
            }
            current = next;
        }

        return current;
    }
}
