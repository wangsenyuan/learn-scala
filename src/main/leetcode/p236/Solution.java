package p236;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by senyuanwang on 15/7/13.
 */
public class Solution {

    private boolean findNode(TreeNode cur, TreeNode target, List<TreeNode> path) {
        if (cur == target) {
            path.add(target);
            return true;
        }
        if (cur == null) {
            return false;
        }

        if (findNode(cur.left, target, path)) {
            path.add(cur);
            return true;
        }

        if (findNode(cur.right, target, path)) {
            path.add(cur);
            return true;
        }
        return false;
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pAncestors = ancestors(root, p);

        List<TreeNode> qAncestors = ancestors(root, q);

        if (pAncestors.size() < qAncestors.size()) {
            return lca(pAncestors, qAncestors.subList(qAncestors.size() - pAncestors.size(), qAncestors.size()));
        }
        return lca(pAncestors.subList(pAncestors.size() - qAncestors.size(), pAncestors.size()), qAncestors);
    }

    private TreeNode lca(List<TreeNode> as, List<TreeNode> bs) {
        int i = 0;
        int j = as.size();
        while (i <= j) {
            int k = i + (j - i) / 2;
            if (as.get(k) == bs.get(k)) {
                j = k - 1;
            } else {
                i = k + 1;
            }
        }
        return as.get(j + 1);
    }

    private List<TreeNode> ancestors(TreeNode root, TreeNode p) {
        List<TreeNode> pAncestors = new ArrayList<>();
        findNode(root, p, pAncestors);
        pAncestors.add(root);
        return pAncestors;
    }



    public static void main(String[] args) {
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(1);
        b.right = a;
        System.out.println(new Solution().lowestCommonAncestor(b, a, b).val);
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
