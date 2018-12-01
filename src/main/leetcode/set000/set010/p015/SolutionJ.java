package set000.set010.p015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangsenyuan on 1/2/16.
 */
public class SolutionJ {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            twoSum(nums, i + 1, nums.length, -nums[i], result);
        }

        return result;
    }

    public void twoSum(int[] nums, int start, int end, int target, List<List<Integer>> result) {
        int i = start, j = end - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < target) {
                i += 1;
            } else if (sum > target) {
                j -= 1;
            } else {
                result.add(Arrays.asList(-target, nums[i], nums[j]));
                do {
                    i++;
                } while (i < j && nums[i] == nums[i - 1]);

                do {
                    j--;
                } while (i < j && nums[j] == nums[j + 1]);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        SolutionJ solution = new SolutionJ();
        List<List<Integer>> result = solution.threeSum(nums);
        System.out.println(result);
    }
}
