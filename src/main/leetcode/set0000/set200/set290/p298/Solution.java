package set0000.set200.set290.p298;

import common.TreeNode;
import common.TreeNodeParser;

/**
 * Created by wangsenyuan on 12/10/2016.
 */
public class Solution implements TreeNodeParser {

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root, 0, root.val);
    }

    private int helper(TreeNode root, int len, int target) {
        if (root == null) {
            return len;
        }

        if (root.val == target) {
            len++;
        } else {
            len = 1;
        }

        int left = helper(root.left, len, root.val + 1);
        int right = helper(root.right, len, root.val + 1);
        return Math.max(len, Math.max(left, right));
    }

    public static void main(String[] args) {
        String str = "[1,2,3,4,5]";
        Solution solution = new Solution();
        TreeNode root = solution.parseAsTreeNode(str);
        System.out.println(solution.longestConsecutive(root));
    }
}
