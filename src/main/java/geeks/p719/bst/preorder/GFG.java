package geeks.p719.bst.preorder;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by wangsenyuan on 5/23/16.
 */
public class GFG {

    private static boolean slowIsPreOrder(int[] nums, int i, int j) {
        if (i + 1 >= j) {
            return true;
        }

        int root = nums[i];
        for (int k = i + 1; k < j; k++) {
            if (nums[k] < root) {
                continue;
            }

            for (int m = k; m < j; m++) {
                if (nums[m] < root) {
                    return false;
                }
            }

            return slowIsPreOrder(nums, i + 1, k) && slowIsPreOrder(nums, k, j);
        }

        return slowIsPreOrder(nums, i + 1, j);
    }

    private static boolean fastIsPreOrder(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (root > nums[i]) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                root = stack.pop();
            }
            stack.push(nums[i]);
        }
        return true;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = scanner.nextInt();
            }
            boolean y = fastIsPreOrder(nums);
            if (y) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }

    }

}
