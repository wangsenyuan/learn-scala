package set100.set140.p143

import scala.annotation.tailrec

/**
  * Definition for singly-linked list.
  **/
class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

object Solution {
  def reorderList(head: ListNode): Unit = {
    if (head != null && head.next != null) {
      val sz = size(head)

      val mid = seek(head, (sz + 1) / 2)

      val tail = reverse(mid)

      var a = head
      var b = tail

      while (a != null && b != null) {
        val an = a.next
        val bn = b.next
        a.next = b
        b.next = an
        a = an
        b = bn
      }
    }
  }

  private def reverse(head: ListNode): ListNode = {
    def go(prev: ListNode, cur: ListNode): ListNode = {
      if (cur.next == null) {
        cur.next = prev
        cur
      } else {
        val next = cur.next
        cur.next = prev
        go(cur, next)
      }
    }

    go(null, head)
  }

  private def size(head: ListNode): Int = {
    @tailrec
    def go(head: ListNode, res: Int): Int = {
      if (head == null) {
        res
      } else {
        go(head.next, res + 1)
      }
    }

    go(head, 0)
  }

  private def seek(head: ListNode, n: Int): ListNode = {
    if (n == 0) {
      null
    } else if (n == 1) {
      head
    } else {
      seek(head.next, n - 1)
    }
  }
}
