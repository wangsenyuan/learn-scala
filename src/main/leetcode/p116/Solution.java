package p116;

/**
 * Created by senyuanwang on 16/8/14.
 */
public class Solution {

    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        TreeLinkNode a = root;

        while (a != null) {
            if (a.left == null && a.next == null) {
                break;
            }

            if (a.left != null) {
                a.left.next = a.right;
            }

            if (a.left != null) {
                TreeLinkNode b = a.left;
                while (b.right != null && b.right != a) {
                    b = b.right;
                }
                if (b.right == a) {
                    b.right = null;
                    a = a.right;
                } else {
                    b.right = a;

                    if (a.right != null && a.next != null) {
                        a.right.next = a.next.left;
                    }

                    a = a.left;
                }
            } else {
                a = a.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeLinkNode root = fromNums(new int[]{-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}, 0);
        inOrderOutput(root);
        System.out.println();
        Solution solution = new Solution();
        solution.connect(root);
        levelOutput(root, 0);
    }

    public static TreeLinkNode fromNums(int[] nums, int i) {
        if (i >= nums.length) {
            return null;
        }
        TreeLinkNode root = new TreeLinkNode(nums[i]);
        root.left = fromNums(nums, 2 * i + 1);
        root.right = fromNums(nums, 2 * i + 2);
        return root;
    }

    public static void levelOutput(TreeLinkNode root, int col) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + ",");
        if (root.next != null) {
            levelOutput(root.next, col + 1);
        }

        if (col == 0 && root.left != null) {
            System.out.println();
            levelOutput(root.left, col);
        }
    }

    public static void inOrderOutput(TreeLinkNode root) {
        if (root == null) {
            System.out.print("_");
            return;
        }

        System.out.printf("%d{", root.val);
        inOrderOutput(root.left);
        inOrderOutput(root.right);
        System.out.print("}");
    }
}
