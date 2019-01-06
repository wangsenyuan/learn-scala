package set100.set170.p174;

/**
 * Created by senyuanwang on 15/3/14.
 */
public class Solution1 {
    public static void main(String[] args) {
        /*int[][] test = new int[][]{
                new int[]{-2, -3, 3},
                new int[]{-5, -10, 1},
                new int[]{10, 30, -5}
        };*/

        int[][] test = new int[][] {new int[] {1, 0, 0}};

        int hp = calculateMinimumHP(test);

        System.out.println(hp);
    }

    public static int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;

        int[] dp = new int[m];
        if (dungeon[n - 1][m - 1] > 0) {
            dp[m - 1] = 1;
        } else {
            dp[m - 1] = -dungeon[n - 1][m - 1] + 1;
        }

        for (int j = m - 2; j >= 0; j--) {
            dp[j] = max(1, dp[j + 1] - dungeon[n - 1][j]);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[j] = dp[j] - dungeon[i][j];
                if (j < m - 1 && dp[j + 1] - dungeon[i][j] < dp[j]) {
                    dp[j] = dp[j + 1] - dungeon[i][j];
                }
                if (dp[j] < 1) {
                    dp[j] = 1;
                }
            }
        }

        return dp[0];
    }

    private static int max(int a, int b) {
        if (a < b) {
            return b;
        } else {
            return a;
        }
    }
}
