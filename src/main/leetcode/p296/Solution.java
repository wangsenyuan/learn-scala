package p296;

/**
 * Created by wangsenyuan on 11/10/2016.
 */
public class Solution {

    public int minTotalDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] people = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = grid[i][j];
                if (i > 0) {
                    x += people[i - 1][j];
                }
                if (j > 0) {
                    x += people[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    x -= people[i - 1][j - 1];
                }
                people[i][j] = x;
            }
        }

        int[][] f = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    f[i][j] += f[i - 1][j] + people[i - 1][j];
                }
                if (j > 0) {
                    f[i][j] += f[i][j - 1] + people[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    f[i][j] -= people[i - 1][j - 1];
                }
            }
        }
        int[][] g = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i < m - 1) {
                    g[i][j] +=
                        g[i + 1][j] + people[m - 1][n - 1] + people[i + 1][j] - people[m - 1][j] - people[i + 1][n - 1];
                }
                if (j < n - 1) {
                    g[i][j] +=
                        g[i][j + 1] + people[m - 1][n - 1] + people[i][j + 1] - people[m - 1][j + 1] - people[i][n - 1];
                }

                if (i < m - 1 && j < n - 1) {
                    g[i][j] -=
                        people[m - 1][n - 1] + people[i + 1][j + 1] - people[m - 1][j + 1] - people[i + 1][n - 1];
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (f[i][j] + g[i][j] < res) {
                    res = f[i][j] + g[i][j];
                }
            }
        }
        return res;
    }
}
