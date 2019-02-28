package set300.set390.p398;

import java.util.Random;

/**
 * Created by wangsenyuan on 9/12/16.
 */
public class Solution1 {
    private int[] nums;

    public Solution1(int[] nums) {
        this.nums = nums;
    }

    private Random r = new Random();

    public int pick(int target) {
        int ret = -1;
        if (nums == null) {
            return ret;
        }
        int upbound = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (r.nextInt(upbound) == 0) {
                    ret = i;
                }
                upbound++;
            }
        }
        return ret;
    }
}
