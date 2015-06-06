package p222.ct.count;

/**
 * Created by senyuanwang on 15/6/6.
 */
public class Solution {

    static int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }

    public static int countNodes(TreeNode root) {
        int h = height(root);
        return h < 0 ? 0 :
                height(root.right) == h - 1 ? (1 << h) + countNodes(root.right)
                        : (1 << h - 1) + countNodes(root.left);
    }

    public static TreeNode fromArray(int[] array, int i) {
        if (i >= array.length) {
            return null;
        }
        TreeNode treeNode = new TreeNode(array[i]);
        treeNode.left = fromArray(array, i * 2);
        treeNode.right = fromArray(array, i * 2 + 1);
        return treeNode;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5};
        TreeNode treeNode = fromArray(array, 1);
        System.out.println(countNodes(treeNode));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}