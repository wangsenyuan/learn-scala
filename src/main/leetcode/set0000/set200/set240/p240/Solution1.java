package set0000.set200.set240.p240;

/**
 * Created by senyuanwang on 15/7/23.
 */
public class Solution1 {

    public boolean searchMatrix(int[][] matrix, int target) {
        return find(matrix, 0, matrix[0].length - 1, target);
    }


    private boolean find(int[][] matrix, int i, int j, int target) {
        if(i >= matrix.length || j < 0) {
            return false;
        } else if(matrix[i][j] == target) {
            return true;
        } else if(matrix[i][j] > target) {
            return find(matrix, i, j - 1, target);
        } else {
            return find(matrix, i + 1, j, target);
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {{-5}};

        Solution1 solution = new Solution1();
        System.out.println(solution.searchMatrix(matrix, -2));
    }
}
