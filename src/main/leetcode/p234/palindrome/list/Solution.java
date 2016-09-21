package p234.palindrome.list;

/**
 * Created by senyuanwang on 15/7/11.
 */
public class Solution {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head, fast = head;
        ListNode rev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode tmp = slow.next;
            slow.next = rev;
            rev = slow;
            slow = tmp;
        }

        if (fast != null) {
            slow = slow.next;
        }

        head = slow;

        boolean check = true;
        while (rev != null) {
            check = check && rev.val == slow.val;
            ListNode tmp = rev.next;
            rev.next = head;
            head = rev;
            rev = tmp;
            slow = slow.next;
        }

        return check;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(2);
        b.next = c;
        a.next = b;
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(a));
    }
}
