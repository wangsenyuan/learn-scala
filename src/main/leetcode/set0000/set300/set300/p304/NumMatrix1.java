package set0000.set300.set300.p304;

/**
 * Created by senyuanwang on 15/11/12.
 */
public class NumMatrix1 {
    long[][] sumMatrix;

    public NumMatrix1(int[][] matrix) {
        int m = matrix.length;

        if (m == 0) {
            return;
        }

        int n = matrix[0].length;

        sumMatrix = new long[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int x = matrix[i - 1][j - 1];

                sumMatrix[i][j] = sumMatrix[i - 1][j] + sumMatrix[i][j - 1] + x - sumMatrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return (int) (sumMatrix[row2 + 1][col2 + 1] + sumMatrix[row1][col1] - sumMatrix[row2 + 1][col1] - sumMatrix[row1][col2 + 1]);
    }

    public static void main(String[] args) {
        int[][] grid = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };

        NumMatrix1 numMatrix1 = new NumMatrix1(grid);

        System.out.println(numMatrix1.sumRegion(2, 1, 4, 3));
    }
}
