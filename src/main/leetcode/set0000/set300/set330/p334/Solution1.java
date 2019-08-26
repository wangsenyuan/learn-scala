package set0000.set300.set330.p334;

/**
 * Created by wangsenyuan on 10/11/2016.
 */
public class Solution1 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4};
        System.out.println(new Solution1().increasingTriplet(nums));
    }

    public boolean increasingTriplet(int[] nums) {
        int i = -1;
        int j = -1;
        for (int k = 0; k < nums.length; k++) {
            if (i == -1 || nums[k] <= nums[i]) {
                i = k;
            } else if (j == -1 || nums[k] <= nums[j]) {
                j = k;
            } else {
                return true;
            }
        }

        return false;
    }
}
