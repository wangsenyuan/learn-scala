package set0000.set000.set080.p083

object Solution {
  def deleteDuplicates(head: ListNode): ListNode = {
    def go(prev: ListNode, cur: ListNode): ListNode = {
      if (cur == null) {
        null
      } else if (prev == null || cur.x != prev.x) {
        cur.next = go(cur, cur.next)
        cur
      } else {
        go(cur, cur.next)
      }
    }

    go(null, head)
  }
}


/**
  * Definition for singly-linked list.
  **/
class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}
