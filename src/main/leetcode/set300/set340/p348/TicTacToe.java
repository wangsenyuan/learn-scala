package set300.set340.p348;

/**
 * Created by wangsenyuan on 5/5/16.
 */
public class TicTacToe {
    private final int[][] board;
    private final int n;

    /**
     * Initialize your data structure here.
     */
    public TicTacToe(int n) {
        this.n = n;
        this.board = new int[n][n];
        for (int i = 0; i < n; i++) {
            this.board[i] = new int[n];
        }
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        int x;
        if (player == 1) {
            x = 1;
        } else {
            x = -1;
        }

        board[row][col] = x;

        boolean win = false;

        win = win || checkRow(row, x);
        win = win || checkCol(col, x);
        win = win || checkDiagonal(row, col, x);
        if (win) {
            return player;
        }
        return 0;
    }

    private boolean checkDiagonal(int row, int col, int x) {
        if (row != col && row + col != n - 1) {
            return false;
        }

        return checkDiagonal1(x) || checkDiagonal2(x);
    }

    private boolean checkDiagonal2(int x) {
        for (int i = 0; i < n; i++) {
            if (board[i][n - 1 - i] != x) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonal1(int x) {
        for (int i = 0; i < n; i++) {
            if (board[i][i] != x) {
                return false;
            }
        }

        return true;
    }


    private boolean checkCol(int col, int x) {
        for (int i = 0; i < n; i++) {
            if (board[i][col] != x) {
                return false;
            }
        }

        return true;
    }

    private boolean checkRow(int row, int x) {
        for (int j = 0; j < n; j++) {
            if (board[row][j] != x) {
                return false;
            }
        }

        return true;
    }
}
