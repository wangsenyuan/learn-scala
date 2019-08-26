package set0000.set100.set150.p156;

/**
 * Created by senyuanwang on 15/8/15.
 */
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return root;
        }

        TreeNode leftRoot = upsideDownBinaryTree(root.left);

        TreeNode tmpNode = leftRoot;

        while(tmpNode.right != null) {
            tmpNode = tmpNode.right;
        }

        tmpNode.left = root.right;
        tmpNode.right = root;

        root.right = null;
        root.left = null;
        return leftRoot;
    }
}
