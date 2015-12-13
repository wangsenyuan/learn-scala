package minimum.height.trees.p310;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by senyuanwang on 15/11/26.
 */
public class Solution {

    private int visit(int p, int x, int len, int[] heights, List<Integer>[] graph) {
        List<Integer> neighbors = graph[x];

        int maxHeight = 0;
        for (int neighbor : neighbors) {
            if (neighbor == p) {
                continue;
            }

            maxHeight = Math.max(maxHeight, visit(x, neighbor, len + 1, heights, graph));
        }
        heights[x] = Math.max(maxHeight, len);
        return maxHeight + 1;
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] heights = new int[n];
        List<Integer>[] graph = new List[n];

        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];

            if (graph[a] == null) {
                graph[a] = new ArrayList<>();
            }

            graph[a].add(b);

            if (graph[b] == null) {
                graph[b] = new ArrayList<>();
            }

            graph[b].add(a);
        }

        visit(-1, 0, 0, heights, graph);

        int minHeight = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (heights[i] < minHeight) {
                minHeight = heights[i];
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (heights[i] == minHeight) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] edges ={{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};

        List<Integer> result = solution.findMinHeightTrees(6, edges);

        System.out.println(result.toString());
    }
}
