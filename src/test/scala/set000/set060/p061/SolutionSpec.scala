package set000.set060.p061

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "right shift 1->2->3->4->5 by 2" should "get 4->5->1->2->3" in {
    val head = ListNode("1->2->3->4->5")
    val res = Solution.rotateRight(head, 2)
    val str = res.toString()
    str shouldEqual "4->5->1->2->3"
  }

  "right shift 0->1->2 by 4" should "get 2->0->1" in {
    val head = ListNode("0->1->2")
    val res = Solution.rotateRight(head, 4)
    val str = res.toString()
    str should be("2->0->1")
  }
}
