package set200.set200.p209;

/**
 * Created by senyuanwang on 15/5/12.
 */
public class Solution1 {

    public static int minSubArrayLen(int s, int[] nums) {
        int n = nums.length + 1;
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

        return len > n ? 0 : len;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 4};
        System.out.print(minSubArrayLen(4, nums));
    }
}
