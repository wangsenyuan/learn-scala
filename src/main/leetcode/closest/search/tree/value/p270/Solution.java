package closest.search.tree.value.p270;

/**
 * Created by senyuanwang on 15/8/27.
 */
public class Solution {
    public int closestValue(TreeNode root, double target) {
        if (root.left == null && root.right == null) {
            return root.val;
        }

        if (target > root.val && root.right != null) {
            int rightClosest = closestValue(root.right, target);
            if (target - root.val < Math.abs(target - rightClosest)) {
                return root.val;
            } else {
                return rightClosest;
            }
        }

        if (target < root.val && root.left != null) {
            int leftClosest = closestValue(root.left, target);
            if (root.val - target < Math.abs(target - leftClosest)) {
                return root.val;
            } else {
                return leftClosest;
            }
        }

        return root.val;
    }
}
