package set0000.set500.set540.p549;

import common.TreeNode;
import common.TreeNodeParser;

/**
 * Created by wangsenyuan on 09/04/2017.
 */
public class Solution implements TreeNodeParser {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = solution.parseAsTreeNode("[1,2,3,4]");
        System.out.println(solution.longestConsecutive(root));
    }

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = longestConsecutive(root.left);
        int right = longestConsecutive(root.right);

        int ans = Math.max(left, right);
        int center = visit(root, true) + visit(root, false) - 1;
        return Math.max(ans, center);
    }

    private int visit(TreeNode root, boolean asc) {
        if (root == null) {
            return 0;
        }
        int res = 1;
        if (asc) {
            if (root.left != null && root.left.val == root.val + 1) {
                res = 1 + visit(root.left, asc);
            }
            if (root.right != null && root.right.val == root.val + 1) {
                int tmp = 1 + visit(root.right, asc);
                if (tmp > res) {
                    res = tmp;
                }
            }
        } else {
            if (root.left != null && root.left.val == root.val - 1) {
                res = 1 + visit(root.left, asc);
            }
            if (root.right != null && root.right.val == root.val - 1) {
                int tmp = 1 + visit(root.right, asc);
                if (tmp > res) {
                    res = tmp;
                }
            }
        }
        return res;
    }
}
