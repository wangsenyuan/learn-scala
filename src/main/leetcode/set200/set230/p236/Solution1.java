package set200.set230.p236;

import common.TreeNode;

/**
 * Created by wangsenyuan on 16/12/2016.
 */
public class Solution1 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left = new TreeNode(3);
        System.out.println(new Solution1().lowestCommonAncestor(root, root.left, root.right).val);
    }

    private void toArray(TreeNode root, TreeNode[] a, int[] p, int px, int[] l, int level, int[] idx) {
        if (root == null) {
            return;
        }
        int i = idx[0]++;
        a[i] = root;
        p[i] = px;
        l[i] = level;

        toArray(root.left, a, p, i, l, level + 1, idx);
        toArray(root.right, a, p, i, l, level + 1, idx);
    }

    private int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int n = count(root);
        TreeNode[] nodes = new TreeNode[n];
        int[] parent = new int[n];
        int[] level = new int[n];
        int[] idx = new int[1];

        toArray(root, nodes, parent, -1, level, 0, idx);

        int k = log2(0, 1, n);
        int[][] dp = new int[n][k + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; 1 << j < n; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            dp[i][0] = parent[i];
        }

        for (int j = 1; 1 << j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (dp[i][j] == -1 && dp[i][j - 1] >= 0) {
                    dp[i][j] = dp[dp[i][j - 1]][j - 1];
                }
            }
        }

        int x = find(nodes, p);
        int y = find(nodes, q);

        if (level[x] < level[y]) {
            int tmp = x;
            x = y;
            y = tmp;
        }

        int logx = log2(0, 1, level[x]);

        for (int i = logx; i >= 0; i--) {
            if (level[x] - (1 << i) >= level[y]) {
                x = dp[x][i];
            }
        }

        if (x == y) {
            return nodes[x];
        }

        for (int i = logx; i >= 0; i--) {
            if (dp[x][i] != -1 && dp[x][i] != dp[y][i]) {
                x = dp[x][i];
                y = dp[y][i];
            }
        }
        return nodes[parent[x]];
    }

    private int find(TreeNode[] nodes, TreeNode p) {
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == p) {
                return i;
            }
        }
        return -1;
    }

    private int log2(int i, int x, int y) {
        if (2 * x > y) {
            return i;
        }
        return log2(i + 1, 2 * x, y);
    }
}
