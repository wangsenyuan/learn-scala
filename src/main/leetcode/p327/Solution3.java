package p327;

import java.util.Arrays;

/**
 * Created by wangsenyuan on 08/11/2016.
 */
public class Solution3 {


    public int countRangeSum(int[] nums, int lower, int upper) {
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
}
