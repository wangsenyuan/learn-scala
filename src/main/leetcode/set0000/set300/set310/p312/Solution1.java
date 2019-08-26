package set0000.set300.set310.p312;

/**
 * Created by wangsenyuan on 28/10/2016.
 */
public class Solution1 {
    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        System.out.println(maxCoins(nums));
    }

    public static int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] f = new int[n + 2][n + 2];

        for (int k = 1; k <= n; k++) {
            for (int i = 0; i + k < n + 1; i++) {
                int j = i + k + 1;
                int a = 1;
                if (i > 0) {
                    a = nums[i - 1];
                }
                int b = 1;
                if (j < n + 1) {
                    b = nums[j - 1];
                }
                for (int m = i + 1; m < j; m++) {
                    if (a * nums[m - 1] * b + f[i][m] + f[m][j] > f[i][j]) {
                        f[i][j] = a * nums[m - 1] * b + f[i][m] + f[m][j];
                    }
                }
            }
        }

        return f[0][n + 1];
    }
}
