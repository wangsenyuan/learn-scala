package geeks.p670.palidromic.array;

import java.util.Scanner;

/**
 * Created by wangsenyuan on 5/24/16.
 */
public class GFG {

    public static int fun(int[] nums, int i, int j) {
        if (i >= j) {
            return 0;
        }

        if (nums[i] == nums[j]) {
            return fun(nums, i + 1, j - 1);
        }

        if (nums[i] > nums[j]) {
            nums[j - 1] += nums[j];
            return fun(nums, i, j - 1) + 1;
        }

        nums[i + 1] += nums[i];
        return fun(nums, i + 1, j) + 1;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = scanner.nextInt();
            }
            int minOps = fun(nums, 0, n - 1);
            System.out.println(minOps);
        }
    }
}
