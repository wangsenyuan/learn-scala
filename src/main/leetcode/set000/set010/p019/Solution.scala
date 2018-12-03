package set000.set010.p019

import common.{ListNode, ListNodeParser}

object Solution extends ListNodeParser {
  def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
    def go(cur: ListNode): (Int, ListNode) = {
      if (cur == null) {
        (0, cur)
      } else {
        val (i, next) = go(cur.next)
        if (i == n) {
          cur.next = next.next
        }
        (i + 1, cur)
      }
    }

    val (i, res) = go(head)
    if (i == n) {
      res.next
    } else {
      res
    }
  }
}
