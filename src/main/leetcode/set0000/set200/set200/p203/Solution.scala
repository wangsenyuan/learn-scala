package set0000.set200.set200.p203

/**
  * Definition for singly-linked list.
  **/
class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

object Solution {
  def removeElements(head: ListNode, `val`: Int): ListNode = {
    var node = head
    while (node != null && node.x == `val`) {
      node = node.next
    }

    if (node == null) {
      null
    } else {
      var cur = node
      while (cur != null) {
        var tmp = cur.next
        while (tmp != null && tmp.x == `val`) {
          tmp = tmp.next
        }
        //tmp == null or tmp.x != val
        cur.next = tmp
        cur = tmp
      }

      node
    }
  }
}
