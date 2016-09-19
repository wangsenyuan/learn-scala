package p230.kth.smallest;

/**
 * Created by wangsenyuan on 9/19/16.
 */
public class Solution1 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        System.out.println(kthSmallest(root, 2));
    }

    public static int kthSmallest(TreeNode root, int k) {
        int left = size(root.left);
        if (left == k - 1) {
            return root.val;
        }

        if (left > k - 1) {
            return kthSmallest(root.left, k);
        }

        return kthSmallest(root.right, k - left - 1);
    }

    private static int size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return size(root.left) + size(root.right) + 1;
    }

}
