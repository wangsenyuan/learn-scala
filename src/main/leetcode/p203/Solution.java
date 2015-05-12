package p203;

/**
 * Created by senyuanwang on 15/4/23.
 */
public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode nHead = head;
        while (nHead != null && nHead.val == val) {
            nHead = nHead.next;
        }

        ListNode tmp = nHead;

        while (tmp != null && tmp.next != null) {
            ListNode grand = tmp.next.next;
            if (tmp.next.val == val) {
                //remove the next;
                tmp.next = grand;
            } else {
                tmp = tmp.next;
            }
        }

        return nHead;
    }
}
