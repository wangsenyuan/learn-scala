package set0000.set100.set160.p160;

/**
 * Created by senyuanwang on 15/3/15.
 */
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int a = sizeOf(headA);
        int b = sizeOf(headB);

        int diff = a - b;
        while (diff > 0) {
            headA = headA.next;
            diff--;
        }

        while (diff < 0) {
            headB = headB.next;
            diff++;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int sizeOf(ListNode head) {
        int n = 0;
        while (head != null) {
            n++;
            head = head.next;
        }
        return n;
    }

}
