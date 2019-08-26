package set0000.set100.set140.p143

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "1->2->3->4" should "get 1->4->2->3" in {
    val head = new ListNode(1)
    head.next = new ListNode(2)
    head.next.next = new ListNode(3)
    head.next.next.next = new ListNode(4)
    Solution.reorderList(head)
    head.x should be(1)
    head.next.x should be(4)
    head.next.next.x should be(2)
    head.next.next.next.x should be(3)
    head.next.next.next.next should be(null)
  }

  "1->2->3->4-5" should "get 1->5->2->4->3" in {
    val head = new ListNode(1)
    head.next = new ListNode(2)
    head.next.next = new ListNode(3)
    head.next.next.next = new ListNode(4)
    head.next.next.next.next = new ListNode(5)
    Solution.reorderList(head)
    head.x should be(1)
    head.next.x should be(5)
    head.next.next.x should be(2)
    head.next.next.next.x should be(4)
    head.next.next.next.next.x should be(3)
    head.next.next.next.next.next should be(null)
  }
}
