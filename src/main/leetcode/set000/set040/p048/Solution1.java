package set000.set040.p048;

/**
 * Created by wangsenyuan on 7/15/16.
 */
public class Solution1 {

    public void rotate(int[][] matrix) {
        doRotate(matrix, matrix.length, 0);
    }

    private void doRotate(int[][] matrix, int width, int i) {
        if (width < 2) {
            return;
        }

        doRotate(matrix, width - 2, i + 1);

        for (int k = 0; k < width - 1; k++) {
            int j = i + k;
            int x = matrix[i][j];
            matrix[i][j] = matrix[i + width - 1 - k][i];
            matrix[i + width - 1 - k][i] = matrix[i + width - 1][i + width - 1 - k];
            matrix[i + width - 1][i + width - 1 - k] = matrix[j][i + width - 1];
            matrix[j][i + width - 1] = x;
        }
    }
}
