package p307;

/**
 * Created by wangsenyuan on 26/10/2016.
 */
public class NumArray {
    private long[] sums;
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        this.sums = new long[n + 1];

        for (int i = 0; i < n; i++) {
            doUpdate(i, nums[i]);
        }
    }

    void doUpdate(int i, int delta) {
        int index = i + 1;
        while (index < sums.length) {
            this.sums[index] += delta;
            index += lsb(index);
        }
    }

    void update(int i, int val) {
        doUpdate(i, val - nums[i]);
        nums[i] = val;
    }

    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i - 1);
    }


    private int getSum(int i) {
        int index = i + 1;
        int sum = 0;
        while (index > 0) {
            sum += this.sums[index];
            index -= lsb(index);
        }
        return sum;
    }

    private int lsb(int i) {
        return i & (-i);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2));
    }
}
