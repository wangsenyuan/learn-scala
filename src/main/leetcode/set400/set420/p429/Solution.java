package set400.set420.p429;

import java.util.ArrayList;
import java.util.List;

/*
// Definition for a Node.
*/
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Node> level = new ArrayList<>();
        List<Node> next = new ArrayList<>();
        level.add(root);
        while(!level.isEmpty()) {
            List<Integer> nums = new ArrayList<>();
            next.clear();
            for(Node node : level) {
                nums.add(node.val);
                if(node.children != null) {
                    for(Node child : node.children) {
                        if(child != null) {
                            next.add(child);
                        }
                    }
                }
            }
            result.add(nums);
            level.clear();
            level.addAll(next);
        }
        return result;
    }
}
