package set1000.set1000.set1010.p1019


/**
 * Definition for singly-linked list.
 **/
class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

object Solution {

  def nextLargerNodes(head: ListNode): Array[Int] = {
    var n = 0
    var node = head
    while (node != null) {
      n += 1
      node = node.next
    }

    val ans = Array.ofDim[Int](n)
    val stack = Array.ofDim[Int](n)
    val values = Array.ofDim[Int](n)
    var i = 0
    node = head
    while (node != null) {
      values(i) = node.x
      i += 1
      node = node.next
    }

    var p = 0

    i = 0
    while (i < n) {
      while (p > 0 && values(stack(p - 1)) < values(i)) {
        ans(stack(p - 1)) = values(i)
        p -= 1
      }
      stack(p) = i
      p += 1
      i += 1
    }

    ans
  }
}
