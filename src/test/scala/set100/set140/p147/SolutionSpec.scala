package set100.set140.p147

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "4->2->1->3" should "get 1->2->3->4" in {
    val head = new ListNode(4)
    head.next = new ListNode(2)
    head.next.next = new ListNode(1)
    head.next.next.next = new ListNode(3)
    val newHead = Solution.insertionSortList(head)
    newHead.x should be(1)
    newHead.next.x should be(2)
    newHead.next.next.x should be(3)
    newHead.next.next.next.x should be(4)
  }
}
