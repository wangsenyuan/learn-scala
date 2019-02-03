package set300.set310.p311;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangsenyuan on 27/10/2016.
 */
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || A[0] == null || B == null || B[0] == null)
            return null;
        int m = A.length, n = A[0].length, l = B[0].length;
        int[][] C = new int[m][l];
        Map<Integer, HashMap<Integer, Integer>> tableB = new HashMap<>();

        for (int k = 0; k < n; k++) {
            tableB.put(k, new HashMap<>());
            for (int j = 0; j < l; j++) {
                if (B[k][j] != 0) {
                    tableB.get(k).put(j, B[k][j]);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int k = 0; k < n; k++) {
                if (A[i][k] != 0) {
                    for (Integer j : tableB.get(k).keySet()) {
                        C[i][j] += A[i][k] * tableB.get(k).get(j);
                    }
                }
            }
        }
        return C;
    }
}
