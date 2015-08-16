package p257.binary.tree.leaf.path;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by senyuanwang on 15/8/16.
 */
public class Solution {
    private void binaryTreePaths(TreeNode current, String path, List<String> paths) {
        String currentPath = path + current.val;

        if (current.left == null && current.right == null) {
            paths.add(currentPath);
            return;
        }


        if (current.left != null) {
            binaryTreePaths(current.left, currentPath + "->", paths);
        }

        if (current.right != null) {
            binaryTreePaths(current.right, currentPath + "->", paths);
        }

    }


    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();

        binaryTreePaths(root, "", result);
        return result;
    }
}
