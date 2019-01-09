package set200.set200.p200;

/**
 * Created by senyuanwang on 15/4/9.
 */
public class Solution2 {

    public static void main(String[] args) {
        String input = "11000\n" +
                "11000\n" +
                "00100\n" +
                "00011";
        String[] lines = input.split("\n");
        char[][] grid = new char[lines.length][lines[0].length()];

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            grid[i] = line.toCharArray();
        }
        int result = numIslands(grid);
        System.out.println(result);
    }

    private static int[][] dirs = new int[][]{
            new int[]{-1, 0},
            new int[]{0, -1},
            new int[]{1, 0},
            new int[]{0, 1}
    };

    public static int numIslands(char[][] grid) {
        int n = grid.length;
        if(n == 0) {
            return 0;
        }
        int m = grid[0].length;
        if(m == 0) {
            return 0;
        }

        boolean[][] flag = new boolean[n][m];

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!flag[i][j] && grid[i][j] == '1') {
                    visit(grid, flag, n, m, i, j);
                    count += 1;
                }
            }
        }
        return count;
    }

    public static void visit(char[][] grid, boolean[][] flag, int n, int m, int i, int j) {
        for (int[] dir : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;

            if (inRange(x, y, n, m) && grid[x][y] == '1' && !flag[x][y]) {

                flag[x][y] = true;
                visit(grid, flag, n, m, x, y);
            }
        }
    }

    private static boolean inRange(int x, int y, int n, int m) {
        if (x < 0 || x >= n) {
            return false;
        }

        if (y < 0 || y >= m) {
            return false;
        }

        return true;
    }
}
