package set0000.set400.set430.p430;

/*
// Definition for a Node.
*/
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {
    }

    public Node(int _val, Node _prev, Node _next, Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};


public class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return head;
        }
        flattenUntilTail(head);
        return head;
    }

    public Node flattenUntilTail(Node head) {
        Node prev = null;
        Node node = head;
        while (node != null) {
            if (node.child != null) {
                Node childHead = node.child;
                node.child = null;

                Node childTail = flattenUntilTail(childHead);

                Node next = node.next;

                node.next = childHead;
                childHead.prev = node;

                childTail.next = next;
                if (next != null) {
                    next.prev = childTail;
                }
                node = childTail;
            }
            prev = node;
            node = node.next;
        }
        return prev;
    }
}
