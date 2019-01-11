package set200.set210.p213;

/**
 * Created by senyuanwang on 15/5/20.
 */
public class Solution1 {
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static int rob(int[] num, int start, int end) {
        if (end - start < 1) {
            return 0;
        }

        if (end - start == 1) {
            return num[start];
        }

        if (end - start == 2) {
            return max(num[start], num[start]);
        }

        int a = num[start];
        int b = max(num[start], num[start + 1]);

        for (int i = start + 2; i < end; i++) {
            int c = a + num[i];
            a = b;
            b = max(b, c);
        }

        return b;
    }

    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        return max(rob(nums, 0, n - 1), rob(nums, 1, n));
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 0};
        System.out.println(rob(nums));
    }
}
