package p444;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by senyuanwang on 2016/10/30.
 */
public class Solution {
    public static void main(String[] args) {
        int[] org = {1, 2, 3, 4, 5};
        int[][] seqs = {{1, 2, 3, 4, 5}, {1, 2, 3, 4}, {1, 2, 3}, {1}, {4}, {5}};
        System.out.println(sequenceReconstruction(org, seqs));
    }

    public static boolean sequenceReconstruction(int[] org, int[][] seqs) {
        int n = org.length;
        int[] degree = new int[n + 1];
        List<Integer>[] graph = new List[n + 1];

        for (int[] seq : seqs) {
            for (int i = 1; i < seq.length; i++) {
                int x = seq[i - 1];
                int y = seq[i];
                degree[y]++;
                if (graph[x] == null) {
                    graph[x] = new ArrayList<>();
                }
                graph[x].add(y);
            }
        }

        for (int i = 0; i < org.length; i++) {
            int v = org[i];
            if (degree[v] != 0) {
                return false;
            }
            if (graph[v] == null) {
                if (i < org.length - 1) {
                    return false;
                }
                continue;
            }
            for (int w : graph[v]) {
                degree[w]--;
            }
        }
        return true;
    }
}
