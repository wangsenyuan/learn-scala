package battleovercities;

import java.util.*;

/**
 * Created by senyuanwang on 15/4/12.
 */
public class Main {

    static class Solution {
        private int[][] roads;
        private int[] num;
        private int[] low;
        private int[] parent;
        private boolean[] visited;
        private int n;
        private int counter;

        public Solution(int[][] roads, int n) {
            this.n = n;
            this.roads = roads;
            this.num = new int[n + 1];
            this.low = new int[n + 1];
            this.parent = new int[n + 1];
            this.visited = new boolean[n + 1];
            this.counter = 0;
        }


        private void assignNum(int v) {
            num[v] = counter++;
            visited[v] = true;
            for (int i = 1; i <= n; i++) {
                if (!visited[i] && roads[v][i] > 0) {
                    parent[i] = v;
                    assignNum(i);
                }
            }
        }

        private void assignLow(int v) {
            low[v] = num[v];  //rule 1

            for (int i = 1; i <= n; i++) {
                if (num[i] > num[v]) {
                    //forward edge
                    assignLow(i);
                    if (low[i] >= num[v]) {
//                        anticulationPoints[v] = true;
                    }
                    low[v] = Math.min(low[v], low[i]);  //rule 3
                } else if (parent[v] != i) {
                    //back edge
                    low[v] = Math.min(low[v], num[i]); //rule 2
                }
            }
        }

        public List<Integer> findCriticalPoints() {
            List<Integer> list = new ArrayList<Integer>();

            for (int i = 1; i <= n; i++) {
                counter = 0;
                Arrays.fill(visited, false);

                parent[i] = 0;
                assignNum(i);
                assignLow(i);

                int effort = findMinumEffortAfterRemoval(i);
            }

            return list;
        }


        private int findMinumEffortAfterRemoval(int v) {
            int childrenGroupCount = 0;
            for (int j = 1; j <= n; j++) {
                if (parent[j] == v) {
                    childrenGroupCount += 1;
                }
            }
            if (childrenGroupCount == 1) {
                return 0;
            }

            return 0;
        }
    }
}
