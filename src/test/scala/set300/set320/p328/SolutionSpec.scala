package set300.set320.p328

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "1->2->3->4->5" should "get 1->3->5->2->4" in {
    val head = new ListNode(1)
    head.next = new ListNode(2)
    head.next.next = new ListNode(3)
    head.next.next.next = new ListNode(4)
    head.next.next.next.next = new ListNode(5)
    val res = Solution.oddEvenList(head)
    res.x should be(1)
    res.next.x should be(3)
    res.next.next.x should be(5)
    res.next.next.next.x should be(2)
    res.next.next.next.next.x should be(4)
  }
}
