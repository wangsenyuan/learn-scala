package set1000.set1300.set1370.p1379;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null) {
            return null;
        }
        if (original == target) {
            return cloned;
        }

        TreeNode res = getTargetCopy(original.left, cloned.left, target);

        if (res != null) {
            return res;
        }

        return getTargetCopy(original.right, cloned.right, target);
    }
}
