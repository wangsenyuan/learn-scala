package set0000.set000.set020.p021

object Solution {

  def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
    def go(l1: ListNode, l2: ListNode): ListNode = {
      if (l1 == null) {
        l2
      } else if (l2 == null) {
        l1
      } else if (l1.x <= l2.x) {
        l1.next = go(l1.next, l2)
        l1
      } else {
        l2.next = go(l1, l2.next)
        l2
      }
    }

    go(l1, l2)
  }
}

/**
  * Definition for singly-linked list.
  **/
class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}
