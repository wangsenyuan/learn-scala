package set0000.set000.set080.p082

/**
  * Definition for singly-linked list.
  */
class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

object Solution {
  def deleteDuplicates(head: ListNode): ListNode = {
    def go(prev: ListNode, cur: ListNode): ListNode = {
      if (cur != null) {
        if ((prev == null || cur.x != prev.x) && (cur.next == null || cur.x != cur.next.x)) {
          //cur will keep
          cur.next = go(cur, cur.next)
          cur
        } else {
          go(cur, cur.next)
        }
      } else {
        null
      }
    }
    go(null, head)
  }
}
