package set0000.set700.set720.p725


/**
  * Definition for singly-linked list.
  **/
class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

object Solution {
  import scala.collection.mutable.ArrayBuffer

  def splitListToParts(root: ListNode, k: Int): Array[ListNode] = {
    val n = size(root)
    val m = n / k
    var need = n - m * k
    val res = ArrayBuffer.empty[ListNode]
    var node = root
    var i = 0
    while(i < k) {
      var j = 0
      res += node
      var prev: ListNode = null
      while(node != null && j < m) {
        prev = node
        node = node.next
        j += 1
      }
      if(j == m && need > 0 && node != null) {
        prev = node
        node = node.next
        need -= 1
      }

      if(prev != null) {
        prev.next = null
      }

      i += 1
    }
    res.toArray
  }

  private def size(root: ListNode): Int = {
    def loop(node: ListNode, ans: Int): Int = {
      if(node == null) {
        ans
      } else {
        loop(node.next, ans + 1)
      }
    }

    loop(root, 0)
  }
}
