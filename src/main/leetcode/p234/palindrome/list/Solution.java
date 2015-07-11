package p234.palindrome.list;

/**
 * Created by senyuanwang on 15/7/11.
 */
public class Solution {
    private int size(ListNode head) {
        int n = 0;
        ListNode tmp = head;
        while(tmp != null) {
            n += 1;
            tmp = tmp.next;
        }
        return n;
    }

    private ListNode reverse(ListNode head) {
        ListNode a = head, b = head.next;
        while(b != null) {
            ListNode c = b.next;
            b.next = a;
            a = b;
            b = c;
        }
        head.next = null;
        return a;
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }

        int n = size(head);

        n = n / 2;

        ListNode a = head, b = head;
        for(int i = 0; i < n; i++) {
            b = b.next;
        }

        ListNode d = reverse(b);

        b = d;

        boolean check = true;

        while(a != null && b != null && check) {
            check = a.val == b.val;
            a = a.next;
            b = b.next;
        }

        reverse(d);


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