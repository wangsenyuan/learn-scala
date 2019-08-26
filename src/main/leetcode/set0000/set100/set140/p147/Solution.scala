package set0000.set100.set140.p147

/**
  * Definition for singly-linked list.
  **/
class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

object Solution {
  def insertionSortList(head: ListNode): ListNode = {
    var node = head
    var tail: ListNode = null
    while (node != null) {
      val next = node.next

      if (tail == null || tail.x >= node.x) {
        node.next = tail
        tail = node
      } else {
        var after: ListNode = null
        var before = tail
        while (before != null && before.x < node.x) {
          after = before
          before = before.next
        }
        after.next = node
        node.next = before
      }

      node = next
    }

    tail
  }
}
