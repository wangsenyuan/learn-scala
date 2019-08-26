package set0000.set000.set020.p023

/**
  * Definition for singly-linked list.
  **/
class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x
}

object Solution {
  def mergeKLists(lists: Array[ListNode]): ListNode = {
    if (lists == null || lists.size == 0) {
      null
    } else if (lists.size == 1) {
      lists(0)
    } else {
      val mid = lists.size / 2
      val a = mergeKLists(lists.slice(0, mid))
      val b = mergeKLists(lists.slice(mid, lists.size))
      merge(a, b)
    }
  }

  def mergeKLists1(lists: Array[ListNode]): ListNode = {
    if (lists == null || lists.size == 0) {
      null
    } else if (lists.size == 1) {
      lists(0)
    } else {
      lists.reduce(merge)
    }
  }

  private def merge(a: ListNode, b: ListNode): ListNode = {
    def go(a: ListNode, b: ListNode): ListNode = {
      if (a == null) {
        b
      } else if (b == null) {
        a
      } else if (a.x <= b.x) {
        a.next = go(a.next, b)
        a
      } else {
        b.next = go(a, b.next)
        b
      }
    }

    go(a, b)
  }
}
