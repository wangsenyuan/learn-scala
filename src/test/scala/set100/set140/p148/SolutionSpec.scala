package set100.set140.p148

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "4->2->1->3" should "get 1->2->3->4" in {
    val head = new ListNode(4)
    head.next = new ListNode(2)
    head.next.next = new ListNode(1)
    head.next.next.next = new ListNode(3)
    val newHead = Solution.sortList(head)
    newHead.x should be(1)
    newHead.next.x should be(2)
    newHead.next.next.x should be(3)
    newHead.next.next.next.x should be(4)
    newHead.next.next.next.next should be(null)
  }

  "-1->5->3->4->0" should "get -1->0->3->4->5" in {
    val head = new ListNode(-1)
    head.next = new ListNode(5)
    head.next.next = new ListNode(3)
    head.next.next.next = new ListNode(4)
    head.next.next.next.next = new ListNode(0)

    val newHead = Solution.sortList(head)
    newHead.x should be(-1)
    newHead.next.x should be(0)
    newHead.next.next.x should be(3)
    newHead.next.next.next.x should be(4)
    newHead.next.next.next.next.x should be(5)
    newHead.next.next.next.next.next should be(null)
  }
}
