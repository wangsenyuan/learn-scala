package set300.set320.p329;

/**
 * Created by wangsenyuan on 1/20/16.
 */
public class Solution1 {

    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return 0;
        }
        int[][] path = new int[m][n];

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (path[i][j] > 0) {
                    max = Math.max(max, path[i][j]);
                    continue;
                }
                max = Math.max(max, longestIncreasingPath(matrix, i, j, path));
            }
        }

        return max;
    }

    public int longestIncreasingPath(int[][] matrix, int i, int j, int[][] path) {
        if (path[i][j] > 0) {
            return path[i][j];
        }

        int longestPath = 1;

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (!isValid(x, y, matrix)) {
                continue;
            }
            if (matrix[x][y] <= matrix[i][j]) {
                continue;
            }

            longestPath = Math.max(longestPath, longestIncreasingPath(matrix, x, y, path) + 1);
        }

        path[i][j] = longestPath;

        return longestPath;
    }

    private boolean isValid(int x, int y, int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        return 0 <= x && x < m && 0 <= y && y < n;
    }
}
