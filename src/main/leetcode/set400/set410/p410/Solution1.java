package set400.set410.p410;

/**
 * Created by senyuanwang on 16/10/3.
 */
public class Solution1 {

    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        /**
         * dp[i] = split nums from i that have the minimum max sub array sum
         */
        int[] dp = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = nums[i];
            if (i < n - 1) {
                dp[i] += dp[i + 1];
            }
        }

        for (int x = 2; x <= m; x++) {
            int y = n + 1 - x;
            for (int i = 0; i < y; i++) {
                dp[i] = Integer.MAX_VALUE;
                int leftSum = 0;
                for (int j = i; j < y; j++) {
                    leftSum += nums[j];
                    if (leftSum > dp[i]) {
                        break;
                    }
                    int z = Math.max(dp[j + 1], leftSum);
                    if (z < dp[i]) {
                        dp[i] = z;
                    }
                }
            }
        }
        return dp[0];
    }
}
