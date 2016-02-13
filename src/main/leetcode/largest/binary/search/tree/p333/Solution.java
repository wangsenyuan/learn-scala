package largest.binary.search.tree.p333;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by senyuanwang on 16/2/13.
 */
public class Solution {
    class Result {
        int res;
        int min;
        int max;

        public Result(int res, int min, int max) {
            this.res = res;
            this.min = min;
            this.max = max;
        }
    }

    public int largestBSTSubtree(TreeNode root) {
        Result res = BSTSubstree(root);
        return Math.abs(res.res);
    }

    private Result BSTSubstree(TreeNode root) {
        if (root == null) return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        Result left = BSTSubstree(root.left);
        Result right = BSTSubstree(root.right);
        if (left.res < 0 || right.res < 0 || root.val < left.max || root.val > right.min) {
            return new Result(Math.max(Math.abs(left.res), Math.abs(right.res)) * -1, 0, 0);
        } else {
            return new Result(left.res + right.res + 1, Math.min(root.val, left.min), Math.max(root.val, right.max));
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(1);
        Solution solution = new Solution();
        System.out.println(solution.largestBSTSubtree(treeNode));
    }
}
