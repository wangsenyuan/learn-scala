package set000.set090.p092

/**
  * Definition for singly-linked list.
  **/
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
  def reverseBetween(head: ListNode, m: Int, n: Int): ListNode = {
    def go(a: ListNode, b: ListNode, cur: ListNode, i: Int): ListNode = {
      if (cur == null) {
        null
      } else if (i < m) {
        cur.next = go(null, null, cur.next, i + 1)
        cur
      } else if (i == m) {
        go(cur, cur, cur.next, i + 1)
      } else if (i < n) {
        val next = cur.next
        cur.next = a
        go(cur, b, next, i + 1)
      } else if (i == n) {
        val next = cur.next
        cur.next = a
        b.next = go(null, null, next, i + 1)
        cur
      } else {
        cur
      }
    }

    if (m == n) {
      head
    } else {
      go(null, null, head, 1)
    }
  }
}
