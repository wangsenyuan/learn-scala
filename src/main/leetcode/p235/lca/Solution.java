package p235.lca;


import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<TreeNode> ancestors(TreeNode root, TreeNode p) {
        List<TreeNode> list = new ArrayList<>();

        while(root != p) {
            list.add(root);
            if(p.val > root.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        list.add(p);
        return list;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pAncestors = ancestors(root, p);
        List<TreeNode> qAncestors = ancestors(root, q);
        int i = 0;
        for(; i < pAncestors.size() && i < qAncestors.size(); i++) {
            TreeNode pAncestor = pAncestors.get(i);
            TreeNode qAncestor = qAncestors.get(i);
            if(pAncestor != qAncestor) {
                return pAncestors.get(i - 1);
            }
        }
        if(i == pAncestors.size()) {
            return pAncestors.get(i - 1);
        } else if(i == qAncestors.size()) {
            return qAncestors.get(i - 1);
        }
        return null;
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