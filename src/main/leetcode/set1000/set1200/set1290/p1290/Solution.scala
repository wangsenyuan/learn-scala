package set1000.set1200.set1290.p1290

/**
 * Definition for singly-linked list.
 **/
class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

object Solution {
  def getDecimalValue(head: ListNode): Int = {
    var res = 0
    var node = head
    while (node != null) {
      res = res << 1 | node.x
      node = node.next
    }
    res
  }
}
