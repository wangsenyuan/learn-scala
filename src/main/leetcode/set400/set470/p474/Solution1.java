package set400.set470.p474;

/**
 * Created by senyuanwang on 2016/12/11.
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
//        String[] strs = {"10", "0001", "111001", "1", "0"};
//        String[] strs = {"10", "0001", "111001", "1", "0"};
        String[] strs = {"10", "0", "1"};
        int m = 1;
        int n = 1;
        System.out.println(solution1.findMaxForm(strs, m, n));
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (String str : strs) {
            int a = 0;
            int b = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '0') {
                    a++;
                } else {
                    b++;
                }
            }

            for (int i = m; i >= a; i--) {
                for (int j = n; j >= b; j--) {
                    if (1 + dp[i - a][j - b] > dp[i][j]) {
                        dp[i][j] = 1 + dp[i - a][j - b];
                    }
                }
            }
        }

        return dp[m][n];
    }

}
