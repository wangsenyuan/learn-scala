package set0000.set000.set020.p025

import scala.annotation.tailrec

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

object Solution {
  def reverseKGroup(head: ListNode, k: Int): ListNode = {
    val (can, nextHead) = takeKNodes(head, k)
    if (!can) {
      head
    } else {
      val newHead = reverse(head, nextHead)
      head.next = reverseKGroup(nextHead, k)
      newHead
    }
  }

  private def takeKNodes(head: ListNode, k: Int): (Boolean, ListNode) = {
    @tailrec
    def go(cur: ListNode, i: Int): (Boolean, ListNode) = {
      if (cur == null) {
        (false, null)
      } else if (i == k) {
        (true, cur.next)
      } else {
        go(cur.next, i + 1)
      }
    }

    go(head, 1)
  }

  private def reverse(head: ListNode, last: ListNode): ListNode = {
    var res: ListNode = null
    var cur = head
    while (cur != last) {
      val tmp = cur.next
      cur.next = res
      res = cur
      cur = tmp
    }
    res
  }
}
