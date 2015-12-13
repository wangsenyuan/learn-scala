package binary.tree.vertical.order.traversal.p314;

import java.util.*;

/**
 * Created by senyuanwang on 15/12/13.
 */
public class Solution {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        Queue<WrappedTreeNode> queue = new LinkedList<>();

        queue.offer(new WrappedTreeNode(root, 0));
        Map<Integer, List<Integer>> result = new HashMap<>();

        while(!queue.isEmpty()) {
            WrappedTreeNode x = queue.poll();
            int column = x.column;
            if(!result.containsKey(column)) {
                result.put(column, new ArrayList<>());
            }
            result.get(column).add(x.node.val);

            TreeNode node = x.node;
            if(node.left != null) {
                queue.offer(new WrappedTreeNode(node.left, column - 1));
            }
            if(node.right != null) {
                queue.offer(new WrappedTreeNode(node.right, column + 1));
            }
        }

        Integer[] keys = result.keySet().toArray(new Integer[]{});
        Arrays.sort(keys);
        List<List<Integer>> list = new ArrayList<>(keys.length);

        for (Integer key : keys) {
            list.add(result.get(key));
        }
        return list;
    }

    class WrappedTreeNode {
        final TreeNode node;
        final int column;

        WrappedTreeNode(TreeNode node, int column) {
            this.node = node;
            this.column = column;
        }
    }

}
