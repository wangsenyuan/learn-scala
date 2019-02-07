package set300.set320.p328

/**
  * Definition for singly-linked list.
  **/
class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}


object Solution {
  def oddEvenList(head: ListNode): ListNode = {
    if (head == null || head.next == null || head.next.next == null) {
      head
    } else {
      var a = head
      var b = head.next
      val bb = b
      a.next = null
      var i = 2
      var cur = b.next
      b.next = null
      while (cur != null) {
        if (i % 2 == 0) {
          //even
          a.next = cur
          a = cur
        } else {
          b.next = cur
          b = cur
        }
        i += 1
        val next = cur.next
        cur.next = null
        cur = next
      }

      a.next = bb
      head
    }
  }
}
