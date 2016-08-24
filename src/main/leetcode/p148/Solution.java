package p148;

/**
 * Created by wangsenyuan on 8/24/16.
 */
public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        Solution solution = new Solution();
        head = solution.sortList(head);
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;
        return merge(sortList(head), sortList(mid));
    }


    private ListNode merge(ListNode a, ListNode b) {
        ListNode head = new ListNode(0);
        ListNode prev = head;
        while (a != null || b != null) {
            if (b == null || (a != null && a.val < b.val)) {
                prev.next = a;
                prev = a;
                a = a.next;
            } else {
                prev.next = b;
                prev = b;
                b = b.next;
            }
        }
        return head.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
