package set100.set150.p153;

/**
 * Created by wangsenyuan on 8/25/16.
 */
public class Solution1 {

    public int findMin(int[] nums) {
        int i = 0;
        int j = nums.length - 1;

        while (i < j && nums[i] == nums[j]) {
            j--;
        }

        while (i < j) {
            int mid = (i + j) / 2;
            if (nums[mid] > nums[j]) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return nums[i];
    }
}
