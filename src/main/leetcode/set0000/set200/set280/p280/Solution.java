package set0000.set200.set280.p280;

/**
 * Created by wangsenyuan on 10/5/16.
 */
public class Solution {
    public void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if ((i % 2 == 0 && nums[i] > nums[i - 1]) || (i % 2 == 1 && nums[i] < nums[i - 1])) {
                int tmp = nums[i - 1];
                nums[i - 1] = nums[i];
                nums[i] = tmp;
            }
        }
    }
}
