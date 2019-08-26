package set0000.set000.set080.p086


object Solution {

  def partition(head: ListNode, x: Int): ListNode = {
    var cur = head
    var lt: ListNode = null
    var ge: ListNode = null
    var a: ListNode = null
    var b: ListNode = null
    while (cur != null) {
      if (cur.x < x) {
        lt = connect(lt, cur)
        if (a == null) {
          a = lt
        }
      } else {
        ge = connect(ge, cur)
        if (b == null) {
          b = ge
        }
      }
      cur = cur.next
    }
    if (ge != null) {
      ge.next = null
    }
    if (lt != null) {
      lt.next = b
      a
    } else {
      b
    }
  }

  private def connect(a: ListNode, b: ListNode): ListNode = {
    if (a != null) {
      a.next = b
    }
    b
  }
}


/**
  * Definition for singly-linked list.
  **/
class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x

  override def toString: String = {
    if (next != null) {
      s"$x->${next.toString}"
    } else {
      s"$x"
    }
  }
}

object ListNode {
  def apply(s: String): ListNode = {
    if (s.isEmpty) {
      null
    } else {
      val ss = s.split("->")
      val head = new ListNode(ss(0).toInt)
      var cur = head
      var i = 1
      while (i < ss.length) {
        cur.next = new ListNode(ss(i).toInt)
        cur = cur.next
        i += 1
      }
      head
    }
  }
}
