package p188;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by senyuanwang on 15/3/5.
 */
public class Solution1 {


    public static int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        if (k > n / 2) {
            int sum = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    sum += prices[i] - prices[i - 1];
                }
            }
            return sum;
        } else {
            int[][] dp = new int[2][n + 1];

            for (int t = 1; t <= k; t++) {
                int cur_max = 0x80000000;
                dp[t % 2][0] = 0;
                for (int i = 0; i < n; i++) {
                    dp[t % 2][i + 1] = max(dp[(t + 1) % 2][i + 1], max(dp[t % 2][i], prices[i] + cur_max));
                    cur_max = max(cur_max, dp[(t + 1) % 2][i] - prices[i]);
                }
            }

            return dp[k%2][n];
        }
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

}
