package set0000.set400.set470.p473;

import java.util.Arrays;

/**
 * Created by senyuanwang on 2016/12/18.
 */
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.makesquare(new int[]{
                1, 1, 2, 2, 2
        }));

        System.out.println(solution1.makesquare(new int[]{
                3, 3, 3, 3, 4
        }));

        System.out.println(solution1.makesquare(new int[]{
                5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3
        }));
    }

    public boolean makesquare(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum == 0 || sum % 4 != 0) {
            return false;
        }

        long side = sum / 4;
        Arrays.sort(nums);

        int flag = 0;
        for (int i = 0; i < 3; i++) {
            flag = check(nums, nums.length, flag, side);
            if (flag < 0) {
                return false;
            }
        }
        return true;
    }

    private int check(int[] nums, int i, int flag, long left) {
        if (left == 0) {
            return flag;
        }

        if (left < 0 || i < 0) {
            return -1;
        }

        for (int j = i - 1; j >= 0; j--) {
            if ((flag & (1 << j)) > 0) {
                continue;
            }

            int ans = check(nums, j, flag | (1 << j), left - nums[j]);
            if (ans > 0) {
                return ans;
            }
        }

        return -1;
    }
}
