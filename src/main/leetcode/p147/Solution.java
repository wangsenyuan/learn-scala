package p147;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode prev = null;

        ListNode tmp = head;
        while (tmp != null) {
            ListNode next = tmp.next;
            if (prev == null || prev.val < tmp.val) {
                tmp.next = prev;
                prev = tmp;
            } else {
                ListNode gt = prev;
                while (gt.next != null && gt.next.val <= tmp.val) {
                    gt = gt.next;
                }

                ListNode x = gt.next;
                gt.next = tmp;
                tmp.next = x;
            }

            tmp = next;
        }


        return prev;
    }
}
