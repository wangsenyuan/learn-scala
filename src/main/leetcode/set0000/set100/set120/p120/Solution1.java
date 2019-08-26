package set0000.set100.set120.p120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangsenyuan on 8/16/16.
 */
public class Solution1 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] fx = new int[n];

        for (int i = 0; i < n; i++) {
            List<Integer> row = triangle.get(i);
            if (i == 0) {
                fx[0] = row.get(0);
                continue;
            }

            for (int j = row.size() - 1; j >= 0; j--) {
                if (j == row.size() - 1) {
                    fx[j] = fx[j - 1] + row.get(j);
                    continue;
                }
                if (j == 0) {
                    fx[j] = fx[j] + row.get(j);
                    continue;
                }
                int a = fx[j - 1];
                int b = fx[j];
                fx[j] = row.get(j) + Math.min(a, b);
            }
        }

        int r = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (fx[i] < r) {
                r = fx[i];
            }
        }

        return r;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        Solution1 solution = new Solution1();
        int r = solution.minimumTotal(triangle);
        System.out.println(r);
    }
}
