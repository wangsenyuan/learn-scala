package move.zeros.p283;

/**
 * Created by senyuanwang on 15/9/20.
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length && nums[j] != 0) {
                j += 1;
            }

            if (i > j && nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        Solution solution = new Solution();
        solution.moveZeroes(nums);
        for (int x : nums) {
            System.out.print(x + " ");
        }
    }
}
