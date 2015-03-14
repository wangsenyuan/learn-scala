package binarysearchtreeiterator;

/*
*
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
*/


import java.util.*;

public class BSTIterator {
    private Stack<TreeNode> path;

    public BSTIterator(TreeNode root) {
        this.path = new Stack<>();
        TreeNode tmp = root;
        while (tmp != null) {
            this.path.push(tmp);
            tmp = tmp.left;
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !path.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode top = path.pop();

        TreeNode tmp = top.right;

        while (tmp != null) {
            path.push(tmp);
            tmp = tmp.left;
        }

        return top.val;
    }
}