package set000.set080.p086

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "1->4->3->2->5->2 and 3" should "get 1->2->2->4->3->5" in {
    val head = ListNode("1->4->3->2->5->2")
    val res = Solution.partition(head, 3)
    val s = res.toString
    s should equal("1->2->2->4->3->5")
  }
}
