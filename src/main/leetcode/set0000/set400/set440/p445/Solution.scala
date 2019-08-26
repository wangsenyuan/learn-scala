package set0000.set400.set440.p445

object Solution {

  /**
    * Definition for singly-linked list.
    **/
  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
  }


  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    val ha = reverse(l1)
    val hb = reverse(l2)


    var node: ListNode = null
    var carry = 0
    var a = ha
    var b = hb
    var h: ListNode = null
    while(a != null && b != null) {
      val sum = a.x + b.x + carry
      val tmp = new ListNode(sum % 10)
      if(node != null) {
        node.next = tmp
      }
      carry = sum / 10
      node = tmp
      if(h == null) {
        h = node
      }
      a = a.next
      b = b.next
    }

    while(a != null) {
      val sum = a.x + carry
      val tmp = new ListNode(sum % 10)
      if(node != null) {
        node.next = tmp
      }
      carry = sum / 10
      node = tmp
      a = a.next
    }

    while(b != null) {
      val sum = b.x + carry
      val tmp = new ListNode(sum % 10)
      if(node != null) {
        node.next = tmp
      }
      carry = sum / 10
      node = tmp
      b = b.next
    }

    if(carry > 0) {
      val tmp = new ListNode(carry)
      node.next = tmp
      node = tmp
    }

    reverse(ha)
    reverse(hb)

    reverse(h)
  }

  private def reverse(list: ListNode): ListNode = {
    def go(prev: ListNode, cur: ListNode): ListNode ={
      if(cur == null) {
        prev
      } else {
        val next = cur.next
        cur.next = prev
        go(cur, next)
      }
    }
    go(null, list)
  }
}
