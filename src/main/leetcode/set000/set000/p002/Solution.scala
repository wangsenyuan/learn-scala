package set000.set000.p002

object Solution {
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    //    val v1 = reverseList(l1)
    //    val v2 = reverseList(l2)

    def add(res: ListNode, v1: ListNode, v2: ListNode, carry: Int): ListNode = {
      if (v1 != null && v2 != null) {
        val sum = v1.x + v2.x + carry
        res.next = new ListNode(sum % 10)
        add(res.next, v1.next, v2.next, sum / 10)
      } else if (v1 != null) {
        val sum = v1.x + carry
        res.next = new ListNode(sum % 10)
        add(res.next, v1.next, null, sum / 10)
      } else if (v2 != null) {
        val sum = v2.x + carry
        res.next = new ListNode(sum % 10)
        add(res.next, null, v2.next, sum / 10)
      } else if (carry == 1) {
        res.next = new ListNode(carry)
        res.next
      } else {
        null
      }
    }

    val head = new ListNode(-1)

    add(head, l1, l2, 0)

    head.next
  }

  def reverseList(node: ListNode): ListNode = {
    def loop(prev: ListNode, cur: ListNode): ListNode = {
      if (prev == null) {
        cur
      } else {
        val node = new ListNode(prev._x)
        node.next = cur
        loop(prev.next, node)
      }
    }

    loop(node, null)
  }

  def constructList(nums: Int*): ListNode = {
    val head = new ListNode(nums(0))
    var node = head
    var i = 1
    while (i < nums.size) {
      node.next = new ListNode(nums(i))
      node = node.next
      i += 1
    }
    head
  }
}


/**
  * Definition for singly-linked list.
  **/
class ListNode(var _x: Int = 0) {
  var next: ListNode = null
  var x: Int = _x

  override def equals(obj: Any): Boolean = {
    obj match {
      case that: ListNode =>
        if (_x == that.x) {
          (next == null && that.next == null) || (next != null && next.equals(that.next))
        } else {
          false
        }
      case _ => false
    }
  }
}
