package problems.simple.p081;

import java.util.*;

/**
 * Created by senyuanwang on 15/4/30.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int k = scanner.nextInt();

        int[] as = new int[n];
        int[] bs = new int[n];

        for (int i = 0; i < n; i++) {
            as[i] = scanner.nextInt();
            bs[i] = scanner.nextInt();
        }

        Node last = new Node(0, new HashSet<Integer>());
        Node head = arrange(as, bs, 0, 1, last, k);
        head = compact(head, k);

        while (head.index > k) {
            head = head.next;
        }
        System.out.println(head.result());
    }


    public static Node compact(Node head, int k) {
        Node node = head;
        List<Node> nodes = new ArrayList<>();
        while (node.index > 0) {
            nodes.add(node);
            node = node.next;
        }

        int index = head.index;
//        boolean updated = false;
        for (int i = 0; i < nodes.size(); i++) {
            Node a = nodes.get(i);
            for (int j = i + 1; j < nodes.size(); j++) {
                Node b = nodes.get(j);
                if (!intersect(a.t, b.t) && (a.r + b.r < head.r)) {
                    Set<Integer> set = new HashSet<Integer>();
                    set.addAll(a.t);
                    set.addAll(b.t);
                    head = fill(a.r + b.r, set, head);
                }
            }
        }

        if (index == head.index) {
            return head;
        } else {
            while (head.index > k) {
                head = head.next;
            }
            return compact(head, k);
        }
    }

    private static boolean intersect(Set<Integer> a, Set<Integer> b) {
        for (int x : a) {
            if (b.contains(x)) {
                return true;
            }
        }
        return false;
    }

    public static Node arrange(int[] as, int[] bs, int i, int t, Node node, int k) {
        int a = as[i];
        int b = bs[i];
        int r = a + b * t;

        Set<Integer> set = new HashSet<Integer>();
        set.add(t);
        Node newNode = fill(r, set, node);

        if (i == 0 && newNode.index >= k) {
            return newNode;
        }

        if (i < as.length - 1) {
            return arrange(as, bs, i + 1, t, newNode, k);
        } else {
            return arrange(as, bs, 0, t + 1, newNode, k);
        }
    }

    private static Node fill(int r, Set<Integer> t, Node node) {
        if (r >= node.result()) {
            Node newNode = new Node(r, t);
            newNode.next = node;
            newNode.index = r == node.result() ? node.index : node.index + 1;
            return newNode;
        } else {
            Node tmp = fill(r, t, node.next);
            node.next = tmp;
            node.index = tmp.result() == node.result() ? tmp.index : tmp.index + 1;
            return node;
        }
    }


    private static class Node {
        public final int r;
        public Set<Integer> t;
        public int index;
        public Node next;

        private Node(int r, Set<Integer> t) {
            this.r = r;
            this.t = t;
            this.index = 0;
        }

        public int result() {
            return r;
        }

        public String toString() {
            if (next != null) {
                return String.format("(%d, %s, %d)", r, t.toString(), index) + "->" + next.toString();
            } else {
                return String.format("(%d, %s, %d)", r, t.toString(), index);
            }
        }
    }
}
