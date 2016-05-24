package p351;

import java.util.HashSet;

/**
 * Created by wangsenyuan on 5/23/16.
 */
public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfPatterns(1, 2));
    }

    public int numberOfPatterns(int m, int n) {
        if (m > n || n <= 0)
            return 0;
        if (n == 1)
            return 9;
        int[] result = new int[1];

        //1, 3, 7, 9
        helper(0, 0, new HashSet<>(), 1, m, n, result);
        //2,4,6,8
        helper(0, 1, new HashSet<>(), 1, m, n, result);
        result[0] *= 4;

        // 5
        helper(1, 1, new HashSet<>(), 1, m, n, result);
        return result[0];
    }

    private void helper(int x, int y, HashSet<Integer> visited, int crt, int m, int n, int[] result) {
        visited.add(convert(x, y));
        if (crt >= m && crt <= n)
            result[0]++;
        if (crt >= n) {
            visited.remove(convert(x, y));
            return;
        }

        int[][] directions =
            new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}, {2, 1}, {1, 2}, {-2, 1},
                {-1, 2}, {2, -1}, {1, -2}, {-2, -1}, {-1, -2}};

        for (int[] direction : directions) {
            int i = x + direction[0];
            int j = y + direction[1];
            if (valid(i, j)) {
                // if visited, try pass (i, j) to another point
                if (visited.contains(convert(i, j))) {
                    i += direction[0];
                    j += direction[1];
                    if (valid(i, j) && !visited.contains(convert(i, j))) {
                        helper(i, j, visited, crt + 1, m, n, result);
                    }
                } else {
                    // take one step further
                    helper(i, j, visited, crt + 1, m, n, result);
                }
            }
        }
        visited.remove(convert(x, y));
    }

    private int convert(int i, int j) {
        return i * 3 + j;
    }

    private boolean valid(int i, int j) {
        return i >= 0 && i < 3 && j >= 0 && j < 3;
    }
}
