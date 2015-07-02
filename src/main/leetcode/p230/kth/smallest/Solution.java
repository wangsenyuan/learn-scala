package p230.kth.smallest;

/**
 * Created by senyuanwang on 15/7/2.
 */
public class Solution {
    public static int kthSmallest(TreeNode root, int k) {
        int[] hk = new int[1], x = new int[1];
        hk[0] = k;
        try {
            travel(root, hk, x);
        } catch (Exception ex) {

        }
        return x[0];
    }

    private static void travel(TreeNode root, int[] k, int[] x) {
        if(root == null) {
            return;
        }

        travel(root.left, k, x);

        if(k[0] == 1) {
            x[0] = root.val;
            throw new RuntimeException();
        }
        k[0]--;
        travel(root.right, k, x);
    }
}


class TreeNode {

    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}
