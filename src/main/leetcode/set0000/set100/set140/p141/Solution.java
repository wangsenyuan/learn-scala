package set0000.set100.set140.p141;


public class Solution {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        listNode.next = listNode;
        Solution solution = new Solution();
        System.out.println(solution.hasCycle(listNode));
    }

    public boolean hasCycle(ListNode head) {
        ListNode a = head;
        ListNode b = head;

        while (a != null && b != null) {
            a = a.next;
            if (b.next == null) {
                return false;
            }
            b = b.next.next;
            if (a == b) {
                return true;
            }
        }

        return false;
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
