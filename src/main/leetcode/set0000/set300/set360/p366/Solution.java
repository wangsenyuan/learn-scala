package set0000.set300.set360.p366;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangsenyuan on 6/25/16.
 */
public class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(root, result);

        return result;
    }

    private int dfs(TreeNode root, List<List<Integer>> result) {
        if (root == null) {
            return -1;
        }

        int left = dfs(root.left, result);
        int right = dfs(root.right, result);

        int depth = 1 + Math.max(left, right);

        if (depth == result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(depth).add(root.val);
        return depth;
    }
}
