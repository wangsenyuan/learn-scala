package p170.two.sum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by senyuanwang on 15/8/16.
 */
public class TwoSum {
    List<Integer> numbers = new ArrayList<>();
    AVL avl = new AVL();

    public void add(int number) {
        avl.add(number);
        numbers.add(number);
    }

    public boolean find(int value) {
        for (int x : numbers) {
            int y = value - x;
            Node node = avl.find(y);
            if (node == null) {
                continue;
            }

            //when these two numbers equal, need to make sure there at least two numbers added;
            if (x == y && node.count == 1) {
                continue;
            }

            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();

        twoSum.add(1);
        twoSum.add(2);
        System.out.println(twoSum.find(1));
    }

    class AVL {
        Node root;

        private int height(Node root) {
            if (root == null) {
                return -1;
            } else {
                return root.height;
            }
        }

        private Node insert(Node root, int value) {
            if (root == null) {
                root = new Node(value);
            } else if (root.value == value) {
                root.count += 1;
            } else if (root.value < value) {
                //go right;
                root.right = insert(root.right, value);
                if (height(root.right) - height(root.left) == 2) {
                    if (value > root.right.value) {
                        root = singleRotateWithRight(root);
                    } else {
                        root = doubleRotateWithRight(root);
                    }
                }
            } else {
                //go left;
                root.left = insert(root.left, value);
                if (height(root.left) - height(root.right) == 2) {
                    if (value < root.left.value) {
                        root = singleRotateWithLeft(root);
                    } else {
                        root = doubleRotateWithLeft(root);
                    }
                }
            }

            root.height = Math.max(height(root.left), height(root.right)) + 1;
            return root;
        }

        private Node doubleRotateWithRight(Node k3) {
            k3.right = singleRotateWithLeft(k3.right);
            return singleRotateWithRight(k3);
        }

        private Node singleRotateWithRight(Node k2) {
            Node k1 = k2.right;
            k2.right = k1.left;
            k1.left = k2;

            k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
            k1.height = Math.max(height(k1.left), height(k1.right)) + 1;

            return k1;
        }

        private Node doubleRotateWithLeft(Node k3) {
            k3.left = singleRotateWithRight(k3.left);
            return singleRotateWithLeft(k3);
        }

        private Node singleRotateWithLeft(Node k2) {
            Node k1 = k2.left;
            k2.left = k1.right;
            k1.right = k2;

            k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
            k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
            return k1;
        }

        public void add(int value) {
            root = insert(root, value);
        }

        private Node find(Node root, int value) {
            if (root == null) {
                return null;
            }

            if (root.value == value && root.count == 0) {
                return null;
            }

            if (root.value == value) {
                return root;
            }

            if (value > root.value) {
                return find(root.right, value);
            } else {
                return find(root.left, value);
            }
        }

        public Node find(int value) {
            return find(root, value);
        }

        public Node getRoot() {
            return root;
        }
    }

    static class Node {
        final int value;
        int count, height;
        Node left, right;

        Node(int value) {
            this.value = value;
            count = 1;
            height = 0;
        }
    }

}
