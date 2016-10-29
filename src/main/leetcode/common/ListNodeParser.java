package common;

/**
 * Created by wangsenyuan on 29/10/2016.
 */
public interface ListNodeParser {

    default ListNode parseAsList(String str) {
        str = str.substring(1, str.length() - 1);
        String[] xs = str.split(",");
        if (xs.length == 0) {
            return null;
        }

        ListNode head = new ListNode(Integer.parseInt(xs[0]));
        ListNode prev = head;
        for (int i = 1; i < xs.length; i++) {
            prev.next = new ListNode(Integer.parseInt(xs[i]));
            prev = prev.next;
        }
        return head;
    }
}
