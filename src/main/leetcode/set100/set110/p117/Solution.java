package set100.set110.p117;

/**
 * Created by senyuanwang on 16/8/14.
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode next = null;
        TreeLinkNode tmp = root.next;
        while (tmp != null && next == null) {
            if (tmp.left != null) {
                next = tmp.left;
            } else if (tmp.right != null) {
                next = tmp.right;
            }
            tmp = tmp.next;
        }
        if (root.right != null) {
            root.right.next = next;
            if (root.left != null) {
                root.left.next = root.right;
            }
        } else if (root.left != null) {
            root.left.next = next;
        }

        connect(root.right);
        connect(root.left);
    }

    public void connect1(TreeLinkNode root) {
        TreeLinkNode head = null; //head of the next level
        TreeLinkNode prev = null; //the leading node on the next level
        TreeLinkNode cur = root;  //current node of current level

        while (cur != null) {

            while (cur != null) { //iterate on the current level
                //left child
                if (cur.left != null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    prev = cur.left;
                }
                //right child
                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    prev = cur.right;
                }
                //move to next node
                cur = cur.next;
            }

            //move to next level
            cur = head;
            head = null;
            prev = null;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeLinkNode root = fromArray(new String[] {"1", "2", "3", "4", "#", "#", "5"}, 0);
        solution.connect(root);
        levelOutput(root, 0);
    }

    private static TreeLinkNode fromArray(String[] array, int i) {
        if (i >= array.length) {
            return null;
        }
        if (array[i] == "#") {
            return null;
        }
        TreeLinkNode root = new TreeLinkNode(Integer.parseInt(array[i]));
        root.left = fromArray(array, 2 * i + 1);
        root.right = fromArray(array, 2 * i + 2);
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
        if (col > 0) {
            return;
        }
        System.out.println();

        if (root.left != null) {
            levelOutput(root.left, col);
        } else if (root.right != null) {
            levelOutput(root.right, col);
        }
    }
}
