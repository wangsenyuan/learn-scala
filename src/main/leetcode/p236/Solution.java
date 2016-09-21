package p236;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by senyuanwang on 15/7/13.
 */
public class Solution {

    static class Result extends RuntimeException {
        final List<TreeNode> path;

        Result(List<TreeNode> path) {
            this.path = path;
        }
    }

    private void findNode(TreeNode cur, TreeNode target, List<TreeNode> path) {
        if (cur == target) {
            path.add(target);
            throw new Result(path);
        }
        if (cur == null) {
            return;
        }
        path.add(cur);

        findNode(cur.left, target, path);
        findNode(cur.right, target, path);

        path.remove(path.size() - 1);
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pAncestors = ancestors(root, p);

        List<TreeNode> qAncestors = ancestors(root, q);

        if (pAncestors.size() < qAncestors.size()) {
            return lca(pAncestors, qAncestors, pAncestors.size());
        }
        return lca(pAncestors, qAncestors, qAncestors.size());
    }

    private TreeNode lca(List<TreeNode> as, List<TreeNode> bs, int len) {
        int i = 0;
        int j = len - 1;
        while (i <= j) {
            int k = i + (j - i) / 2;
            if (as.get(k) == bs.get(k)) {
                i = k + 1;
            } else {
                j = k - 1;
            }
        }
        return as.get(i - 1);
    }

    private List<TreeNode> ancestors(TreeNode root, TreeNode p) {
        List<TreeNode> ancestors = new ArrayList<>();
        try {
            findNode(root, p, ancestors);
            return null;
        } catch (Result result) {
            return result.path;
        }
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left = new TreeNode(3);
        System.out.println(new Solution().lowestCommonAncestor(root, root.left, root.right).val);
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
