package p206;

/**
 * Created by wangsenyuan on 9/9/16.
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode a = head;
        ListNode b = a.next;
        a.next = null;

        while (b != null) {
            ListNode c = b.next;
            b.next = a;
            a = b;
            b = c;
        }
        return a;
    }
}


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
