package p174;

/**
 * Created by senyuanwang on 15/3/14.
 */
public class Solution {
    public static void main(String[] args) {
        /*int[][] test = new int[][]{
                new int[]{-2, -3, 3},
                new int[]{-5, -10, 1},
                new int[]{10, 30, -5}
        };*/

        int[][] test = new int[][]{
                new int[]{1, 0, 0}
        };

        int hp = calculateMinimumHP(test);

        System.out.println(hp);
    }

    public static int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;

        int[][] dp = new int[n][m];

        if (dungeon[n - 1][m - 1] > 0) {
            dp[n - 1][m - 1] = 1;
        } else {
            dp[n - 1][m - 1] = -dungeon[n - 1][m - 1] + 1;
        }

        for (int j = m - 2; j >= 0; j--) {
            dp[n - 1][j] = max(1, dp[n - 1][j + 1] - dungeon[n - 1][j]);
        }

        for (int i = n - 2; i >= 0; i--) {
            dp[i][m - 1] = max(1, dp[i + 1][m - 1] - dungeon[i][m - 1]);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                dp[i][j] = max(1, min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]);
            }
        }

        return dp[0][0];
    }

    private static int min(int a, int b) {
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    private static int max(int a, int b) {
        if (a < b) {
            return b;
        } else {
            return a;
        }
    }
}
