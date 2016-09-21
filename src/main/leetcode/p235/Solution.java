package p235;


public class Solution {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            return lowestCommonAncestor(root, q, p);
        }

        if (p.val <= root.val && root.val <= q.val) {
            return root;
        }

        if (p.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return lowestCommonAncestor(root.left, p, q);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(1);
        b.right = a;
        System.out.println(lowestCommonAncestor(b, a, b).val);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
