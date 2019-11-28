package set1000.set1100.set1170.p1171

/**
 * Definition for singly-linked list.
 **/
class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

object Solution {
  def removeZeroSumSublists(head: ListNode): ListNode = {
    var newHead = new ListNode(-1)
    newHead.next = head
    var cur = newHead
    while (cur != null) {
      var tmp = cur
      var sum = 0
      while (tmp.next != null && sum + tmp.next.x != 0) {
        sum += tmp.next.x
        tmp = tmp.next
      }

      if (tmp.next == null) {
        if (newHead == null) {
          newHead = cur
        }
        cur = cur.next
      } else {
        // sum + tmp.next.x == 0
        cur.next = tmp.next.next
      }
    }

    newHead.next
  }
}
