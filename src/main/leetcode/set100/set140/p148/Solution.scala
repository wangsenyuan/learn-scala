package set100.set140.p148


/**
  * Definition for singly-linked list.
  **/
class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}


object Solution {
  def sortList(head: ListNode): ListNode = {
    val sz = size(head)

    def go(head: ListNode, n: Int): ListNode = {
      if (n <= 1) {
        head
      } else {
        val mid = seek(head, n / 2 - 1)
        val afterMid = mid.next
        mid.next = null
        val a = go(head, n / 2)
        val b = go(afterMid, n - n / 2)
        merge(a, b)
      }
    }

    go(head, sz)
  }

  private def merge(a: ListNode, b: ListNode): ListNode = {
    if (a == null) {
      b
    } else if (b == null) {
      a
    } else if (a.x <= b.x) {
      a.next = merge(a.next, b)
      a
    } else {
      b.next = merge(a, b.next)
      b
    }
  }

  private def seek(head: ListNode, n: Int): ListNode = {
    if (n == 0) {
      head
    } else {
      seek(head.next, n - 1)
    }
  }

  private def size(head: ListNode): Int = {
    def go(head: ListNode, res: Int): Int = {
      if (head == null) {
        res
      } else {
        go(head.next, res + 1)
      }
    }

    go(head, 0)
  }
}

