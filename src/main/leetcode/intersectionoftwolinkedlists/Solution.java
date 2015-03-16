package intersectionoftwolinkedlists;

/**
 * Created by senyuanwang on 15/3/15.
 */
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pa = headA;
        ListNode pb = headB;

        ListNode endA = null;
        ListNode endB = null;

        while (true) {
            if (pa == pb) {
                return pa;
            }

            if (pa.next == null) {
                endA = pa;
                pa = headB;
            } else {
                pa = pa.next;
            }

            if (pb.next == null) {
                endB = pb;
                pb = headA;
            } else {
                pb = pb.next;
            }

            if (endA != null && endB != null && endA != endB) {
                return null;
            }
        }
    }

}
