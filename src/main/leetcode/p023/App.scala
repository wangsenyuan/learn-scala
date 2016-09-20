package p023

/**
  * Created by wangsenyuan on 12/31/15.
  */
object App {


  def merge(a: ListNode, b: ListNode): ListNode = {
    if (a == null) b
    else if (b == null) a
    else if (a.`val` <= b.`val`) {
      val c = new ListNode(a.`val`)
      c.next = merge(a.next, b)
      c
    } else {
      val c = new ListNode(b.`val`)
      c.next = merge(a, b.next)
      c
    }
  }

  def mergeKLists(lists: Array[ListNode]): ListNode = {
    def go(from: Int, to: Int): ListNode = {
      if (from >= to) null
      else if (from + 1 == to) lists(0)
      else {
        val mid = (from + to) / 2
        merge(go(from, mid), go(mid, to))
      }
    }
    go(0, lists.size)
  }
}
