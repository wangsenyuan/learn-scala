package common;

/**
 * Created by wangsenyuan on 29/10/2016.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public String toString() {
        if (next == null) {
            return "" + val;
        }
        return String.format("%d,%s", val, next.toString());
    }
}
