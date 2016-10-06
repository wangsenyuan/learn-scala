package p285;

import common.TreeNode;

/**
 * Created by senyuanwang on 2016/10/6.
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }

        if (p.val >= root.val) {
            return inorderSuccessor(root.right, p);
        }

        TreeNode suc = inorderSuccessor(root.left, p);
        if (suc == null) {
            return root;
        }
        return suc;
    }
}
