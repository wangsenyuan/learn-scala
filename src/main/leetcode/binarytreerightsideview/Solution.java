package binarytreerightsideview;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by senyuanwang on 15/4/6.
 */
public class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<Integer> result = new LinkedList<>();

        visit(root, result, 0, -1);

        return result;
    }


    private static int visit(TreeNode node, List<Integer> result, int level, int gate) {
        if (node == null) {
            return Math.max(level - 1, gate);
        }

        if (level > gate) {
            result.add(node.val);
        }

        int rightGate = visit(node.right, result, level + 1, gate);
        int leftGate = visit(node.left, result, level + 1, rightGate);
        return Math.max(rightGate, leftGate);
    }
}
