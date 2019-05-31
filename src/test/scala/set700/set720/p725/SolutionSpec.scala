package set700.set720.p725

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val root = new ListNode(1)
    root.next = new ListNode(2)
    val res = Solution.splitListToParts(root, 4)
    res.size should be(4)
    res(0) should not be(null)
    res(1) should not be(null)
    res(0).x should equal(1)
    res(1).x should equal(2)
    res(2) should be(null)
  }
}
