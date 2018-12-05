package set000.set020.p024

object Solution {

  def swapPairs(head: ListNode): ListNode = {
    if (head == null || head.next == null) {
      head
    } else {
      val next = head.next
      head.next = swapPairs(next.next)
      next.next = head
      next
    }
  }
}


/**
  * Definition for singly-linked list.
  **/
class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x

  override def toString: String = {
    if (next == null) {
      s"$x"
    } else {
      s"$x->$next"
    }
  }
}

object ListNode {
  def apply(str: String): ListNode = {
    if (str == null || str.isEmpty) {
      null
    } else {
      val ss = str.split("->")
      val head = new ListNode(ss(0).toInt)
      var prev = head
      var i = 1
      while (i < ss.length) {
        prev.next = new ListNode(ss(i).toInt)
        prev = prev.next
        i += 1
      }
      head
    }
  }
}
