package p203;

/**
 * Created by senyuanwang on 15/4/23.
 */
public class Solution {

    public ListNode removeElements(ListNode head, int val) {
        ListNode nHead = new ListNode(-1);
        nHead.next = head;

        ListNode tmp = nHead;

        while (tmp.next != null) {
            ListNode next = tmp.next;
            if (next.val == val) {
                tmp.next = next.next;
            } else {
                tmp = next;
            }
        }

        return nHead.next;
    }
}
