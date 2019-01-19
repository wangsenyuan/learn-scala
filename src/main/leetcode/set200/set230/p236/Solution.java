package set200.set230.p236;

import common.TreeNode;

/**
 * Created by senyuanwang on 15/7/13.
 */
public class Solution {

    static class TreeNodeWrapper {
        final TreeNode treeNode;
        final int level;
        final TreeNodeWrapper parent, lastSegmentParent;
        TreeNodeWrapper left, right;

        public TreeNodeWrapper(TreeNodeWrapper parent, TreeNodeWrapper lastSegmentParent, TreeNode treeNode,
            int level) {
            this.treeNode = treeNode;
            this.level = level;
            this.parent = parent;
            this.lastSegmentParent = lastSegmentParent;
        }
    }

    private TreeNodeWrapper wrapTreeNode(TreeNodeWrapper parent, TreeNode node, int level, int nr) {
        if (node == null) {
            return null;
        }
        TreeNodeWrapper lastSegmentParent = null;
        if (level >= nr) {
            if (level % nr == 0) {
                lastSegmentParent = parent;
            } else if (parent != null) {
                lastSegmentParent = parent.lastSegmentParent;
            }
        }
        TreeNodeWrapper cur = new TreeNodeWrapper(parent, lastSegmentParent, node, level);

        cur.left = wrapTreeNode(cur, node.left, level + 1, nr);
        cur.right = wrapTreeNode(cur, node.right, level + 1, nr);

        return cur;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        if (left > right) {
            return left + 1;
        }
        return right + 1;
    }

    private TreeNodeWrapper find(TreeNodeWrapper root, TreeNode x) {
        if (root == null) {
            return null;
        }

        if (root.treeNode == x) {
            return root;
        }

        TreeNodeWrapper left = find(root.left, x);
        if (left != null) {
            return left;
        }
        return find(root.right, x);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int depth = depth(root);
        int nr = (int) Math.sqrt(depth);
        TreeNodeWrapper rootWrapper = wrapTreeNode(null, root, 0, nr);

        TreeNodeWrapper pWrapper = find(rootWrapper, p);
        TreeNodeWrapper qWrapper = find(rootWrapper, q);

        while (pWrapper.lastSegmentParent != qWrapper.lastSegmentParent) {
            if (pWrapper.level > qWrapper.level) {
                pWrapper = pWrapper.lastSegmentParent;
            } else {
                qWrapper = qWrapper.lastSegmentParent;
            }
        }
        while (pWrapper != qWrapper) {
            if (pWrapper.level > qWrapper.level) {
                pWrapper = pWrapper.parent;
            } else {
                qWrapper = qWrapper.parent;
            }
        }

        return pWrapper.treeNode;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left = new TreeNode(3);
        System.out.println(new Solution().lowestCommonAncestor(root, root.left, root.right).val);
    }
}
