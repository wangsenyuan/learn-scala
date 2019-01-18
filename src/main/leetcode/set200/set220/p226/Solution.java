package set200.set220.p226;

/**
 * Created by senyuanwang on 15/6/12.
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode tmp = invertTree(root.right);
        root.right = invertTree(root.left);
        root.left = tmp;
        return root;
    }
}
