package set0000.set200.set230.p234

/**
  * Definition for singly-linked list.
  **/
class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

object Solution {
  def isPalindrome(head: ListNode): Boolean = {
    val sz = size(head)
    if (sz <= 1) {
      true
    } else {
      val mid = sz / 2
      val midNode = seek(head, mid)
      val first = reverseUtil(head, midNode)
      val second = if (sz % 2 == 0) {
        midNode
      } else {
        midNode.next
      }
      var a = first
      var b = second
      while (a != null && b != null && a.x == b.x) {
        a = a.next
        b = b.next
      }
      val res = a == null && b == null

      reverseUtil(first, null)
      first.next = second

      res
    }
  }

  private def size(head: ListNode): Int = {
    def go(node: ListNode, res: Int): Int = {
      if (node == null) {
        res
      } else {
        go(node.next, res + 1)
      }
    }

    go(head, 0)
  }

  private def seek(head: ListNode, n: Int): ListNode = {
    def go(node: ListNode, n: Int): ListNode = {
      if (n == 0) {
        node
      } else {
        go(node.next, n - 1)
      }
    }

    go(head, n)
  }

  private def reverseUtil(head: ListNode, end: ListNode): ListNode = {
    def go(prev: ListNode, cur: ListNode): ListNode = {
      val next = cur.next
      cur.next = prev
      if (next == end) {
        cur
      } else {
        go(cur, next)
      }
    }

    go(null, head)
  }
}
