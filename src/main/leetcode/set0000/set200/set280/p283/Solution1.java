package set0000.set200.set280.p283;

/**
 * Created by senyuanwang on 15/9/20.
 */
public class Solution1 {
    public void moveZeroes(int[] nums) {
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            nums[p++] = nums[i];
        }

        for (int i = p; i < nums.length; i++) {
            nums[i] = 0;
        }

    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        Solution1 solution1 = new Solution1();
        solution1.moveZeroes(nums);
        for (int x : nums) {
            System.out.print(x + " ");
        }
    }
}
