package set300.set330.p337;

import common.TreeNode;

/**
 * Created by wangsenyuan on 14/11/2016.
 */
public class Solution1 {

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return rob(root, false);
    }

    private int rob(TreeNode root, boolean parentRobbed) {
        if (root == null) {
            return 0;
        }
        int b = rob(root.left, false);
        int c = rob(root.right, false);

        if (parentRobbed) {
            return b + c;
        }

        int a = rob(root.left, true) + rob(root.right, true) + root.val;

        return max(a, b + c);
    }

    private int max(int a, int b) {
        if (a >= b) {
            return a;
        }
        return b;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        int maxRob = new Solution1().rob(root);
        System.out.println(maxRob);

    }
}
