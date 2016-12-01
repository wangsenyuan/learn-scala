package p363;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by wangsenyuan on 30/11/2016.
 */
public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean colGtRow = true;

        if (m > n) {
            colGtRow = false;
            int temp = m;
            m = n;
            n = temp;
        }
        TreeSet<Integer> values = new TreeSet<>();
        int[] cols = new int[n];

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            Arrays.fill(cols, 0);

            for (int j = i; j >= 0; j--) {
                values.clear();
                values.add(0);
                int sum = 0;
                for (int k = 0; k < n; k++) {
                    if (colGtRow) {
                        cols[k] += matrix[j][k];
                    } else {
                        cols[k] += matrix[k][j];
                    }
                    sum += cols[k];
                    Integer candidate = values.ceiling(sum - target);
                    if (candidate != null && sum - candidate > res) {
                        res = sum - candidate;
                    }
                    if (res == target) {
                        return target;
                    }
                    values.add(sum);
                }
            }
        }
        return res;
    }
}
