package set0000.set300.set320.p325;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangsenyuan on 1/6/16.
 */
public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> sumIndex = new HashMap<>();
        int maxDist = 0;
        int sum = 0;
        sumIndex.put(sum, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!sumIndex.containsKey(sum)) {
                sumIndex.put(sum, i);
            }
            int prevSum = sum - k;
            if (sumIndex.containsKey(prevSum)) {
                int j = sumIndex.get(prevSum);
                if (i - j > maxDist) {
                    maxDist = i - j;
                }
            }
        }
        return maxDist;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, -1, 5, -2, 3};
        int len = solution.maxSubArrayLen(nums, 3);
        System.out.println(len);
    }
}
