package p075;

/**
 * Created by senyuanwang on 16/7/23.
 */
public class Solution {

    public void sortColors(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int k = 0;

        while (i < j) {
            if (nums[i] == 0) {
                i++;
                continue;
            }

            while (i < j && nums[j] == 2) {
                j--;
            }

            if (i == j) {
                break;
            }

            if (nums[i] != 1 || nums[j] != 1) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                continue;
            }

            if (k <= i) {
                k = i + 1;
            }

            while (k < j && nums[k] == 1) {
                k++;
            }

            if (k == j) {
                break;
            }

            int tmp = nums[i];
            nums[i] = nums[k];
            nums[k] = tmp;
        }
    }
}
