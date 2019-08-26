package set0000.set200.set270.p272;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by senyuanwang on 15/9/19.
 */
public class Solution {

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> values = new ArrayList<>();
        visit(root, values);

        return helper(target, k, values);
    }

    public List<Integer> helper(double target, int k, List<Integer> values) {
        int x = 0;
        double minDiff = abs(target, values.get(x));

        for (x = 1; x < values.size(); x++) {
            double diff = abs(target, values.get(x));
            if (diff > minDiff) {
                break;
            }
            minDiff = diff;
        }

        x = x - 1;

        int i = x, j = x;

        while (j - i + 1 < k) {
            double diffOne = Double.MAX_VALUE;
            if (i > 0) {
                diffOne = abs(target, values.get(i - 1));
            }
            double diffTwo = Double.MAX_VALUE;
            if (j < values.size() - 1) {
                diffTwo = abs(target, values.get(j + 1));
            }

            if (diffOne < diffTwo) {
                i -= 1;
            } else {
                j += 1;
            }
        }


        return values.subList(i, j + 1);
    }

    private double abs(double a, int b) {
        return Math.abs(a - b);
    }

    private void visit(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        visit(root.left, list);
        list.add(root.val);
        visit(root.right, list);
    }

    public static void main(String[] args) {
        int[] testData = {4, 2, 5, 1, 3};
        Arrays.sort(testData);

        List<Integer> values = new ArrayList<>();
        for (int x : testData) {
            values.add(x);
        }

        Solution solution = new Solution();

        List<Integer> result = solution.helper(4.857143, 3, values);
        System.out.println(result);
    }
}
