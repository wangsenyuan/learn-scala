package set0000.set400.set420.p427;

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
    public Node construct(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return null;
        }
        int n = grid.length;
        int[][] sum = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = grid[i][j];
                if (i > 0) {
                    tmp += sum[i - 1][j];
                }
                if (j > 0) {
                    tmp += sum[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    tmp -= sum[i - 1][j - 1];
                }
                sum[i][j] = tmp;
            }
        }
        return construct(sum, 0, 0, n - 1, n - 1);
    }

    private Node construct(int[][] sum, int a, int b, int c, int d) {
        int x = c - a + 1;
        int y = d - b + 1;
        int tmp = sum[c][d];
        if (a > 0) {
            tmp -= sum[a - 1][d];
        }
        if (b > 0) {
            tmp -= sum[c][b - 1];
        }
        if (a > 0 && b > 0) {
            tmp += sum[a - 1][b - 1];
        }
        if (tmp == 0 || tmp == x * y) {
            return new Node(tmp == x * y, true, null, null, null, null);
        }

        x = (a + c) / 2;
        y = (b + d) / 2;
        Node topLeft = construct(sum, a, b, x, y);
        Node topRight = construct(sum, a, y + 1, x, d);
        Node bottomLeft = construct(sum, x + 1, b, c, y);
        Node bottomRight = construct(sum, x + 1, y + 1, c, d);
        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}
