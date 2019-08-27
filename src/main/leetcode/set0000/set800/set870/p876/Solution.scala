package set0000.set800.set870.p876

/**
 * Definition for singly-linked list.
 **/
class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

object Solution {
  def middleNode(head: ListNode): ListNode = {
    if (head == null || head.next == null) {
      head
    } else {
      var slow = head
      var fast = head
      while (fast != null && fast.next != null) {
        slow = slow.next
        fast = fast.next.next
      }
      slow
    }
  }
}
