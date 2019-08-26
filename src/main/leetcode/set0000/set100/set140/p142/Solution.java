package set0000.set100.set140.p142;

/**
 * Created by wangsenyuan on 8/22/16.
 */
public class Solution {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        ListNode startCycleAt = new Solution().detectCycle(listNode);
        System.out.println(startCycleAt);
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode a = head;
        ListNode b = head;
        while (a != null && b != null) {
            a = a.next;
            if (a == null || b.next == null) {
                return null;
            }
            b = b.next.next;
            if (a == b) {
                break;
            }
        }

        if (b == null) {
            return null;
        }
        ListNode c = head;
        while (c != b) {
            c = c.next;
            b = b.next;
        }
        return c;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
