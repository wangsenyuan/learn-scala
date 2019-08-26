package set0000.set200.set200.p207;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangsenyuan on 9/9/16.
 */
public class Solution1 {

    public static void main(String[] args) {
        int[][] pres = new int[][] {new int[] {1, 0}};
        Solution1 solution = new Solution1();
        System.out.println(solution.canFinish(2, pres));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            if (graph[a] == null) {
                graph[a] = new ArrayList<>();
            }
            graph[a].add(b);
        }

        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && !visit(graph, i, visited)) {
                return false;
            }
        }

        return true;
    }

    private boolean visit(List<Integer>[] graph, int v, int[] visited) {
        visited[v] = 1;

        if (graph[v] != null) {
            for (int w : graph[v]) {
                if (visited[w] == 1) {
                    return false;
                }
                if (visited[w] == 2) {
                    continue;
                }
                if (!visit(graph, w, visited)) {
                    return false;
                }
            }
        }

        visited[v] = 2;
        return true;
    }
}
