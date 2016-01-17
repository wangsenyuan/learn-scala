package odd.even.linked.list.p328;

/**
 * Created by senyuanwang on 16/1/16.
 */
public class Solution {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode second = head.next;

        ListNode a = second.next;
        ListNode[] ptrs = new ListNode[2];
        ptrs[0] = head;
        ptrs[1] = second;
        int index = 0;
        while (a != null) {
            ptrs[index].next = a;
            ptrs[index] = a;
            index = (index + 1) % 2;
            a = a.next;
        }
        ptrs[1].next = null;
        ptrs[0].next = second;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = head;
        for (int i = 2; i <= 8; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }

        head = new Solution().oddEvenList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
