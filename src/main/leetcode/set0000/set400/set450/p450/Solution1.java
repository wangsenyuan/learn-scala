package set0000.set400.set450.p450;

import common.TreeNode;

/**
 * Created by wangsenyuan on 01/11/2016.
 */
public class Solution1 {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        }

        if (root.right == null) {
            return root.left;
        }

        TreeNode prev = root.right;
        if (prev.left == null) {
            prev.left = root.left;
            return prev;
        }

        TreeNode tmp = prev.left;
        while (tmp.left != null) {
            prev = tmp;
            tmp = tmp.left;
        }
        prev.left = tmp.right;
        tmp.right = root.right;
        tmp.left = root.left;
        return tmp;
    }
}
