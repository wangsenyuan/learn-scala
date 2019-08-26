package set0000.set200.set260.p268;

/**
 * Created by wangsenyuan on 9/29/16.
 */
public class Solution1 {
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (x < 0) {
                x = -x;
            }
            while (x < nums.length && nums[x] >= 0) {
                int y = nums[x];
                if (y == 0) {
                    nums[x] = -(nums.length + 1);
                } else {
                    nums[x] = -y;
                }
                x = y;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                return i;
            }
        }
        return nums.length;
    }


    public static void main(String[] args) {
        int[] nums = {0};
        Solution1 solution = new Solution1();
        System.out.println(solution.missingNumber(nums));
    }
}
