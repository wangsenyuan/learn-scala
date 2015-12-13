package rang.sum.query.p303;

/**
 * Created by senyuanwang on 15/11/10.
 */
public class NumArray {
    private long[] sum;

    public NumArray(int[] nums) {
        int n = nums.length;
        sum = new long[n + 1];

        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return (int) (sum[j + 1] - sum[i]);
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }
}
