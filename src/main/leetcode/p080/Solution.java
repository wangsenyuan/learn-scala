package p080;

/**
 * Created by senyuanwang on 16/7/23.
 */
public class Solution {

    public int removeDuplicates(int[] nums) {
        int p = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[p - 1] && p >= 2 && nums[p - 1] == nums[p - 2]) {
                continue;
            }

            nums[p++] = nums[i];
        }

        return p;
    }

}
