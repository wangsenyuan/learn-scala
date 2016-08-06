package p092;

/**
 * Created by senyuanwang on 16/8/6.
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;

        ListNode prev = newHead;
        ListNode curr = head;
        ListNode next = null;

        for (int i = 1; i < n; i++) {
            if (i < m) {
                prev = curr;
                curr = curr.next;
                continue;
            }

            next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        return newHead.next;
    }
}


/*
 * Definition for singly-linked list.
 * */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
