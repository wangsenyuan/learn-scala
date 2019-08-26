package set0000.set200.set230.p237;

import common.ListNode;

public class Solution {
    public void deleteNode(ListNode node) {
        ListNode prev = null;
        while (node.next != null) {
            prev = node;
            node.val = node.next.val;
            node = node.next;
        }
        prev.next = null;
    }
}
