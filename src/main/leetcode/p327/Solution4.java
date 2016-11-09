package p327;

import java.util.Arrays;

/**
 * Created by wangsenyuan on 08/11/2016.
 */
public class Solution4 {


    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        int[] nums = {-2, 5, -1};
        int upper = 2;
        int lower = -2;
        System.out.println(solution.countRangeSum(nums, lower, upper));
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0 || lower > upper) {
            return 0;
        }

        long[] prefixArray = new long[nums.length + 1];

        for (int i = 1; i < prefixArray.length; i++) {
            prefixArray[i] = prefixArray[i - 1] + nums[i - 1];
        }

        return countRangeSumSubI(prefixArray, 0, prefixArray.length, lower, upper);
    }

    private int countRangeSumSubI(long[] prefixArray, int l, int r, int lower, int upper) {
        int m = l + (r - l) / 2;
        if (m == l) {
            return 0;
        }

        int count =
            countRangeSumSubI(prefixArray, l, m, lower, upper) + countRangeSumSubI(prefixArray, m, r, lower, upper);

        int i = m;
        int j = m;
        for (int k = l; k < m; k++) {
            long left = prefixArray[k];
            while (i < r && prefixArray[i] - left < lower) {
                i++;
            }
            while (j < r && prefixArray[j] - left <= upper) {
                j++;
            }
            count += j - i;
        }

        Arrays.sort(prefixArray, l, r);

        return count;
    }
}
