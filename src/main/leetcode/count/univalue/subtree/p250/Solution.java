package count.univalue.subtree.p250;


import geeks.lca.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by senyuanwang on 15/8/23.
 */
public class Solution {

    int count = 0;

    boolean all(TreeNode root, int val) {
        if (root == null)
            return true;
        if (!all(root.left, root.val) | !all(root.right, root.val))
            return false;
        count++;
        return root.val == val;
    }

    public int countUnivalSubtrees(TreeNode root) {
        all(root, 0);
        return count;
    }
}
