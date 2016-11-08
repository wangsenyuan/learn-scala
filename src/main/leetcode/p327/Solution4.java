package p327;

/**
 * Created by wangsenyuan on 08/11/2016.
 */
public class Solution4 {


    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0 || lower > upper) {
            return 0;
        }

        long[] prefixArray = new long[nums.length + 1];

        for (int i = 1; i < prefixArray.length; i++) {
            prefixArray[i] = prefixArray[i - 1] + nums[i - 1];
        }

        return countRangeSumSubI(prefixArray, 0, prefixArray.length - 1, lower, upper);
    }

    private int countRangeSumSubI(long[] prefixArray, int l, int r, int lower, int upper) {
        if (l >= r)
            return 0;

        int m = l + (r - l) / 2;

        int count =
            countRangeSumSubI(prefixArray, l, m, lower, upper) + countRangeSumSubI(prefixArray, m + 1, r, lower, upper);

        long[] mergedArray = new long[r - l + 1];
        int i = l, j = m + 1, k = m + 1, p = 0, q = m + 1;

        while (i <= m) {
            while (j <= r && prefixArray[j] - prefixArray[i] < lower)
                j++;
            while (k <= r && prefixArray[k] - prefixArray[i] <= upper)
                k++;
            count += k - j;

            while (q <= r && prefixArray[q] < prefixArray[i])
                mergedArray[p++] = prefixArray[q++];
            mergedArray[p++] = prefixArray[i++];
        }

        while (q <= r)
            mergedArray[p++] = prefixArray[q++];

        System.arraycopy(mergedArray, 0, prefixArray, l, mergedArray.length);

        return count;
    }
}
