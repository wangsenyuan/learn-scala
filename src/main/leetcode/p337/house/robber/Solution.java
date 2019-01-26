package p337.house.robber;

import set200.set270.p272.TreeNode;

/**
 * Created by wangsenyuan on 4/1/16.
 */
public class Solution {
    public int rob(TreeNode root) {
        int[] robbed = new int[2];
        rob(root, robbed);
        return robbed[0];
    }

    private void rob(TreeNode root, int[] robbed) {
        if (root == null) {
            robbed[0] = 0;
            return;
        }

        if (root.left == null && root.right == null) {
            robbed[0] = root.val;
            return;
        }
        int[] robLeft = new int[2];
        if (root.left != null) {
            rob(root.left, robLeft);
        }

        int[] robRight = new int[2];
        if (root.right != null) {
            rob(root.right, robRight);
        }

        int skipRoot = robLeft[0] + robRight[0];
        int robRoot = robLeft[1] + robRight[1] + root.val;

        robbed[0] = Math.max(skipRoot, robRoot);
        robbed[1] = robLeft[0] + robRight[0];
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        int maxRob = new Solution().rob(root);
        System.out.println(maxRob);

    }
}
