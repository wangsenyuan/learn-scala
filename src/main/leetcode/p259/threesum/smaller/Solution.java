package p259.threesum.smaller;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by senyuanwang on 15/8/17.
 */
public class Solution {

    public int threeSumSmaller(int[] nums, int target) {
        if (nums.length < 3) return 0;
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 2; ++i) {
            if (nums[i] + nums[i + 1] + nums[i + 2] >= target) break;
            for (int j = i + 1; j < nums.length - 1; ++j) {
                if (nums[i] + nums[j] + nums[j + 1] >= target) break;
                for (int k = j + 1; k < nums.length; ++k) {
                    if (nums[i] + nums[j] + nums[k] >= target) {
                        break;
                    } else {
                        res++;
                    }
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1, 0, -1};
        Solution solution = new Solution();
        System.out.println(solution.threeSumSmaller(nums, 0));
    }

}
