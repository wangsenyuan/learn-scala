package set1000.set1000.set1010.p1019

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val head = new ListNode(2)
    head.next = new ListNode(7)
    val res = Solution.nextLargerNodes(head)
    res should be(Array(7, 0))
  }
}
