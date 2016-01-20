package count.of.range.sum.p327;

import java.util.Arrays;

/**
 * Created by senyuanwang on 16/1/17.
 */
public class Solution {

    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0 || lower > upper) {
            return 0;
        }

        return countRangeSumSub(nums, 0, nums.length - 1, lower, upper);
    }


    private int countRangeSumSub(int[] nums, int l, int r, int lower, int upper) {
        if (l == r) {
            return nums[l] >= lower && nums[r] <= upper ? 1 : 0;  // base case
        }

        int m = l + (r - l) / 2;
        long[] arr = new long[r - m];  // prefix array for the second subarray
        long sum = 0;
        int count = 0;

        for (int i = m + 1; i <= r; i++) {
            sum += nums[i];
            arr[i - (m + 1)] = sum; // compute the prefix array
        }

        Arrays.sort(arr);  // sort the prefix array

        // Here we can compute the suffix array element by element.
        // For each element in the suffix array, we compute the corresponding
        // "insertion" indices of the modified bounds in the sorted prefix array
        // then the number of valid ranges sums will be given by the indices difference.
        // I modified the bounds to be "double" to avoid duplicate elements.
        sum = 0;
        for (int i = m; i >= l; i--) {
            sum += nums[i];
            count += findIndex(arr, upper - sum + 0.5) - findIndex(arr, lower - sum - 0.5);
        }

        return countRangeSumSub(nums, l, m, lower, upper) + countRangeSumSub(nums, m + 1, r, lower, upper) + count;
    }

    // binary search function
    private int findIndex(long[] arr, double val) {
        int l = 0, r = arr.length - 1, m = 0;

        while (l <= r) {
            m = l + (r - l) / 2;

            if (arr[m] <= val) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return l;
    }

    public int countRangeSum1(int[] nums, int lower, int upper) {
        long[] sum = new long[nums.length + 1];
        long[] cand = new long[3 * sum.length + 1];
        int index = 0;
        cand[index++] = sum[0];
        cand[index++] = lower + sum[0] - 1;
        cand[index++] = upper + sum[0];

        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            cand[index++] = sum[i];
            cand[index++] = lower + sum[i] - 1;
            cand[index++] = upper + sum[i];
        }

        cand[index] = Long.MIN_VALUE; // avoid getting root of the binary indexed tree when doing binary search
        Arrays.sort(cand);

        int[] bit = new int[cand.length];

        // build up the binary indexed tree with only elements from the prefix array "sum"
        for (int i = 0; i < sum.length; i++) {
            addValue(bit, Arrays.binarySearch(cand, sum[i]), 1);
        }

        int count = 0;

        for (int i = 1; i < sum.length; i++) {
            // get rid of visited elements by adding -1 to the corresponding tree nodes
            addValue(bit, Arrays.binarySearch(cand, sum[i - 1]), -1);

            // add the total number of valid elements with upper bound (upper + sum[i - 1])
            count += query(bit, Arrays.binarySearch(cand, upper + sum[i - 1]));

            // minus the total number of valid elements with lower bound (lower + sum[i - 1] - 1)
            count -= query(bit, Arrays.binarySearch(cand, lower + sum[i - 1] - 1));
        }

        return count;
    }

    private void addValue(int[] bit, int index, int value) {
        while (index < bit.length) {
            bit[index] += value;
            index += index & -index;
        }
    }

    private int query(int[] bit, int index) {
        int sum = 0;

        while (index > 0) {
            sum += bit[index];
            index -= index & -index;
        }

        return sum;
    }

    public int countRangeSumI(int[] nums, int lower, int upper) {
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
        if (l >= r) return 0;

        int m = l + (r - l) / 2;

        int count = countRangeSumSubI(prefixArray, l, m, lower, upper) + countRangeSumSubI(prefixArray, m + 1, r, lower, upper);

        long[] mergedArray = new long[r - l + 1];
        int i = l, j = m + 1, k = m + 1, p = 0, q = m + 1;

        while (i <= m) {
            while (j <= r && prefixArray[j] - prefixArray[i] < lower) j++;
            while (k <= r && prefixArray[k] - prefixArray[i] <= upper) k++;
            count += k - j;

            while (q <= r && prefixArray[q] < prefixArray[i]) mergedArray[p++] = prefixArray[q++];
            mergedArray[p++] = prefixArray[i++];
        }

        while (q <= r) mergedArray[p++] = prefixArray[q++];

        System.arraycopy(mergedArray, 0, prefixArray, l, mergedArray.length);

        return count;
    }
}
