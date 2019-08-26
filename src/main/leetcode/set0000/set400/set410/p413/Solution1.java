package set0000.set400.set410.p413;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by senyuanwang on 2016/11/6.
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        //int[] A = {2, 4, 6, 8, 10};
        int[] A = {0, 2000000000, -294967296};
        System.out.println(numberOfArithmeticSlices(A));
    }

    public static int numberOfArithmeticSlices(int[] A) {
        Map<Long, Integer>[] dp = new Map[A.length];
        int ans = 0;
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < i; j++) {
                long dist = (long) A[i] - (long) A[j];
                int s;
                if (dp[j] == null) {
                    s = 1;
                } else {
                    s = dp[j].getOrDefault(dist, 0) + 1;
                }
                if (dp[i] == null) {
                    dp[i] = new HashMap<>();
                }
                dp[i].put(dist, dp[i].getOrDefault(dist, 0) + s);
                ans += s;
            }
            ans -= i;
        }

        return ans;
    }
}
