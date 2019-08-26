package set0000.set200.set230.p238;

/**
 * Created by senyuanwang on 15/7/16.
 */
public class Solution1 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] result = new int[n];

        result[0] = 1;

        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int product = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            result[i] = result[i] * product;
            product = product * nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Solution1 solution = new Solution1();
        int[] result = solution.productExceptSelf(nums);
        for (int x : result) {
            System.out.print(x + ", ");
        }
    }
}
