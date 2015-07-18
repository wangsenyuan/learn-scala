package p239.sliding.window;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by senyuanwang on 15/7/18.
 */
public class Solution {
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return new int[0];
        }


        int[] result = new int[n - k + 1];

        int index = 0;
        for (int i = 1; i < k; i++) {
            if (nums[result[index]] < nums[i]) {
                result[index] = i;
            }
        }

        for (int i = k; i < n; i++) {
            int j = result[index++];
            int a = nums[j];
            int b = nums[i];
            if (b >= a) {
                result[index] = i;
            } else {
                if (i - j < k) {
                    result[index] = j;
                } else {
                    result[index] = j + 1;
                    for (int m = j + 2; m <= i; m++) {
                        if (nums[result[index]] < nums[m]) {
                            result[index] = m;
                        }
                    }
                }
            }

        }

        for (int i = 0; i < result.length; i++) {
            result[i] = nums[result[i]];
        }

        return result;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return new int[0];
        }
        int[] result = new int[n - k + 1];
        Stack<Integer> stack = new Stack<>(), temp = new Stack<>();
        result[0] = nums[0];
        stack.push(0);
        for (int i = 1; i < k; i++) {
            if (result[0] < nums[i]) {
                result[0] = nums[i];
            }
            int a = nums[i];

            while (!stack.isEmpty() && nums[stack.peek()] < a) {
                stack.pop();
            }
            stack.push(i);
        }
        int index = 1;
        for (int i = k; i < n; i++) {
            int a = nums[i];

            while (!stack.isEmpty() && nums[stack.peek()] < a) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[index++] = a;
            } else {
                if (stack.peek() + k <= i) {
                    result[index++] = a;
                } else {
                    while (!stack.empty() && stack.peek() + k > i) {
                        temp.push(stack.pop());
                    }
                    result[index++] = nums[temp.peek()];
                    while (!temp.empty()) {
                        stack.push(temp.pop());
                    }
                }
            }
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, -1};
        int k = 1;
        Solution solution = new Solution();
        int[] result = solution.maxSlidingWindow(nums, k);

        for (int x : result) {
            System.out.print(x + ", ");
        }
    }
}
