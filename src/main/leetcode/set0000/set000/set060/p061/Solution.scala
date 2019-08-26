package set0000.set000.set060.p061

object Solution {
  def rotateRight(head: ListNode, k: Int): ListNode = {
    val sz = size(head)
    if(sz == 0) {
      head
    } else {
      val n = k % sz
      val m = sz - n
      if (m == 0 || m == sz) {
        head
      } else {
        val pp = seek(head, m - 1)
        val p = pp.next
        pp.next = null
        val a = reverse(head)
        val b = reverse(p)
        val c = seek(a, m - 1)
        c.next = b
        reverse(a)
      }
    }
  }

  private def reverse(head: ListNode): ListNode = {
    var prev: ListNode = null
    var tmp = head

    while (tmp.next != null) {
      val next = tmp.next
      tmp.next = prev
      prev = tmp
      tmp = next
    }
    tmp.next = prev
    tmp
  }

  private def seek(head: ListNode, m: Int): ListNode = {
    if (m == 0) {
      head
    } else {
      seek(head.next, m - 1)
    }
  }

  private def size(head: ListNode): Int = {
    def go(head: ListNode, size: Int): Int = {
      if (head == null) {
        size
      } else {
        go(head.next, size + 1)
      }
    }

    go(head, 0)
  }
}


/**
  * Definition for singly-linked list.
  **/
class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x

  override def toString(): String = {
    if(next == null) {
      s"$x"
    } else {
      s"$x->$next"
    }
  }
}

object ListNode {
  def apply(s: String): ListNode = {
    val ss = s.split("->").map(_.toInt)

    val head = new ListNode(ss(0))
    var prev = head

    var i = 1
    while(i < ss.length) {
      val node = new ListNode(ss(i))
      prev.next = node
      prev = node
      i += 1
    }
    head
  }
}
