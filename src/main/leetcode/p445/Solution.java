package p445;

import common.ListNode;
import common.ListNodeParser;

/**
 * Created by wangsenyuan on 29/10/2016.
 */
public class Solution implements ListNodeParser {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //ListNode l1 = solution.parseAsList("[7,2,4,3]");
        ListNode l1 = solution.parseAsList("[2,4,3]");
        ListNode l2 = solution.parseAsList("[5,6,4]");
        ListNode l3 = solution.addTwoNumbers(l1, l2);
        while (l3 != null) {
            System.out.printf("%d->", l3.val);
            l3 = l3.next;
        }
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Result res = add0(l1, l2, l1, l2);
        if (res.carry == 0) {
            return res.listNode;
        }

        ListNode head = new ListNode(1);
        head.next = res.listNode;
        return head;
    }


    private Result add0(ListNode l1, ListNode l2, ListNode a, ListNode b) {
        if (a.next == null && b.next == null) {
            return add2(l1, l2);
        }
        if (a.next == null) {
            return add1(l2, b.next, l1);
        }

        if (b.next == null) {
            return add1(l1, a.next, l2);
        }

        return add0(l1, l2, a.next, b.next);
    }

    private Result add1(ListNode a, ListNode b, ListNode l3) {
        Result res;
        if (b.next == null) {
            res = add2(a.next, l3);
        } else {
            res = add1(a.next, b.next, l3);
        }

        int sum = a.val + res.carry;
        return new Result(res, sum);
    }

    private Result add2(ListNode a, ListNode b) {
        if (a == null) {
            return new Result((ListNode) null, 0);
        }
        Result sub = add2(a.next, b.next);
        int sum = a.val + b.val + sub.carry;
        return new Result(sub, sum);
    }

    private static class Result {
        ListNode listNode;
        int carry;

        public Result(ListNode listNode, int carry) {
            this.listNode = listNode;
            this.carry = carry;
        }

        public Result(Result sub, int sum) {
            if (sum >= 10) {
                listNode = new ListNode(sum - 10);
                carry = 1;
            } else {
                listNode = new ListNode(sum);
                carry = 0;
            }
            listNode.next = sub.listNode;
        }
    }
}
