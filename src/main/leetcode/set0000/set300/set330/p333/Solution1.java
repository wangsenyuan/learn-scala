package set0000.set300.set330.p333;

/**
 * Created by wangsenyuan on 09/11/2016.
 */
public class Solution1 {

    public int largestBSTSubtree(TreeNode root) {
        if (isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return count(root);
        }

        int left = largestBSTSubtree(root.left);
        int right = largestBSTSubtree(root.right);

        if (left > right) {
            return left;
        }
        return right;
    }

    private boolean isValid(TreeNode root, int minVal, int maxVal) {
        if (root == null) {
            return true;
        }
        if (root.val > maxVal || root.val < minVal) {
            return false;
        }
        return isValid(root.left, minVal, root.val) && isValid(root.right, root.val, maxVal);
    }

    private int count(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + count(root.left) + count(root.right);
    }
}
