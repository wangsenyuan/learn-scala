package p260.single.number;

/**
 * Created by senyuanwang on 15/8/17.
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        // Pass 1 :
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // Get its last set bit
        diff &= -diff;

        // Pass 2 :
        int[] rets = {0, 0}; // this array stores the two numbers we will return
        for (int num : nums) {
            if ((num & diff) == 0) {
                rets[0] ^= num;
            } else {
                rets[1] ^= num;
            }
        }
        return rets;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};
        Solution solution = new Solution();
        int[] res = solution.singleNumber(nums);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
