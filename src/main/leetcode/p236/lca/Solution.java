package p236.lca;

import java.util.ArrayList;
import java.util.List;

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

    private List<TreeNode> ancestors(TreeNode root, TreeNode p) {
        List<TreeNode> pAncestors = new ArrayList<>();
        findNode(root, p, pAncestors);
        pAncestors.add(root);
        pAncestors = reverse(pAncestors);
        return pAncestors;
    }

    private <T> List<T> reverse(List<T> list) {
        List<T> result = new ArrayList<>(list.size());

        for(int i = list.size() - 1; i >= 0; i--) {
            result.add(list.get(i));
        }
        return result;
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