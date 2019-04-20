package set500.set550.p558;

/*
// Definition for a QuadTree node.
*/
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {
    }

    public Node(boolean _val, boolean _isLeaf, Node _topLeft, Node _topRight, Node _bottomLeft, Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};


public class Solution {
    public Node intersect(Node quadTree1, Node quadTree2) {
        if (quadTree1.isLeaf && quadTree2.isLeaf) {
            return new Node(quadTree1.val || quadTree2.val, true, null, null, null, null);
        }
        Node topLeft = null, topRight = null, bottomLeft = null, bottomRight = null;
        if (quadTree1.isLeaf) {
            if (quadTree1.val) {
                Node res = new Node();
                res.isLeaf = true;
                res.val = true;
                return res;
            }
            topLeft = quadTree2.topLeft;
            topRight = quadTree2.topRight;
            bottomLeft = quadTree2.bottomLeft;
            bottomRight = quadTree2.bottomRight;
        } else if (quadTree2.isLeaf) {
            if (quadTree2.val) {
                Node res = new Node();
                res.isLeaf = true;
                res.val = true;
                return res;
            }
            topLeft = quadTree1.topLeft;
            topRight = quadTree1.topRight;
            bottomLeft = quadTree1.bottomLeft;
            bottomRight = quadTree1.bottomRight;
        } else {
            topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
            topRight = intersect(quadTree1.topRight, quadTree2.topRight);
            bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
            bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);
        }

        if (topLeft.val && topLeft.isLeaf && topRight.val && topRight.isLeaf && bottomLeft.val && bottomLeft.isLeaf && bottomRight.val && bottomRight.isLeaf) {
            return new Node(true, true, null, null, null, null);
        }

        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}
