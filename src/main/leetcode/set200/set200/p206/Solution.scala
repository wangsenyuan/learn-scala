package set200.set200.p206

/**
  * Definition for singly-linked list.
  **/
class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

object Solution {
  def reverseList(head: ListNode): ListNode = {
    var prev: ListNode = null
    var cur = head
    while (cur != null) {
      val next = cur.next
      cur.next = prev
      prev = cur
      cur = next
    }
    prev
  }
}
