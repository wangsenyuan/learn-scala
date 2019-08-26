package set0000.set800.set810.p817

/**
 * Definition for singly-linked list.
 **/
class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

object Solution {
  def numComponents(head: ListNode, G: Array[Int]): Int = {
    val set = G.toSet

    var res = 0
    var prev = head

    if(set.contains(prev.x)) {
      res += 1
    }

    var node = head.next

    while(node != null) {
      if(set.contains(node.x)) {
        if(!set.contains(prev.x)) {
          res += 1
        }
      }
      prev = node
      node = node.next
    }

    res
  }
}
