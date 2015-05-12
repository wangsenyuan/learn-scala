package p209.min.subarray.sum;

/**
 * Created by senyuanwang on 15/5/12.
 */
public class Solution {

    public static int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int len = n;
        int sum = 0;
        for (int i = 0, j = 0; i < n; ) {
            while (j < n && sum < s) {
                sum += nums[j++];
            }
            if(sum < s) {
                break;
            }
            len = Math.min(len, j - i);
            sum -= nums[i++];
        }

        return len == n ? 0 : len;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 4};
        System.out.print(minSubArrayLen(4, nums));
    }
}
