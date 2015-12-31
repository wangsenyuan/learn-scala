package merge.k.sorted.lists.p023;

/**
 * Created by wangsenyuan on 12/31/15.
 */
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length);
    }

    public ListNode mergeKLists(ListNode[] lists, int from, int to) {
        if (from >= to) {
            return null;
        }
        if (from == to - 1) {
            return lists[from];
        }

        int mid = (from + to) / 2;
        return merge(mergeKLists(lists, from, mid), mergeKLists(lists, mid, to));
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode c = new ListNode(-1);
        ListNode pc = c;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                pc.next = a;
                pc = pc.next;
                a = a.next;
            } else {
                pc.next = b;
                pc = pc.next;
                b = b.next;
            }
        }

        if (a != null) {
            pc.next = a;
        }

        if (b != null) {
            pc.next = b;
        }
        return c.next;
    }

}
