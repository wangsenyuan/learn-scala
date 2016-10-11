package p289;

/**
 * Created by senyuanwang on 15/10/8.
 */
public class Solution {
    private static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    private static final int ZERO = 0; //dead - dead
    private static final int ONE = 1; //live - live
    private static final int TWO = 2; //dead - live
    private static final int THREE = 3; //live - dead

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = board[i][j];

                int sum = 0;
                for (int k = 0; k < 8; k++) {
                    int _i = i + dx[k];
                    int _j = j + dy[k];
                    if (_i >= 0 && _i < m && _j >= 0 && _j < n) {
                        int _x = board[_i][_j];
                        if (_x == ONE || _x == THREE) {
                            sum += 1;
                        }
                    }
                }
                if (x == 1) {
                    if (sum < 2 || sum > 3) {
                        board[i][j] = THREE;
                    } else {
                        board[i][j] = ONE;
                    }
                } else {
                    if (sum == 3) {
                        board[i][j] = TWO;
                    } else {
                        board[i][j] = ZERO;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == ONE || board[i][j] == TWO) {
                    board[i][j] = ONE;
                } else {
                    board[i][j] = ZERO;
                }
            }
        }
    }
}
