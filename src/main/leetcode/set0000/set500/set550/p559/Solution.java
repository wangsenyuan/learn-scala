package set0000.set500.set550.p559;

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

class Solution {
    public int maxDepth(Node root) {
        if(root == null) {
            return 0;
        }
        if(root.children == null || root.children.isEmpty()) {
            return 1;
        }
        int best = 0;
        for(Node child : root.children) {
            best = Math.max(best, maxDepth(child));
        }
        return best + 1;
    }
}
