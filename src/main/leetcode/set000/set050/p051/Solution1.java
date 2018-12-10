package set000.set050.p051;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangsenyuan on 7/15/16.
 */
public class Solution1 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>(n);
        int[][] board = new int[n][n];
        solve(n, 0, board, result);
        return result;
    }

    private void solve(int n, int i, int[][] board, List<List<String>> result) {
        if (i == n) {
            result.add(toStringList(board));
            return;
        }

        for (int j = 0; j < n; j++) {
            boolean canPlace = true;
            for (int k = 0; k < i; k++) {
                if (board[k][j] == 1) {
                    canPlace = false;
                    break;
                }
                int a = i - k;
                if (j - a >= 0 && board[k][j - a] == 1) {
                    canPlace = false;
                    break;
                }

                if (j + a < n && board[k][j + a] == 1) {
                    canPlace = false;
                    break;
                }

            }

            if (!canPlace) {
                continue;
            }
            board[i][j] = 1;
            solve(n, i + 1, board, result);
            board[i][j] = 0;
        }
    }

    private List<String> toStringList(int[][] board) {
        List<String> strs = new ArrayList<>(board.length);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            sb.setLength(0);
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            strs.add(sb.toString());
        }

        return strs;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        List<List<String>> rs = solution.solveNQueens(8);

        for (List<String> one : rs) {
            System.out.println("==================");
            for (String str : one) {
                System.out.println(str);
            }
        }
    }
}
