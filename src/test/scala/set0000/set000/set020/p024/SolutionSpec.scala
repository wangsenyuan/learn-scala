package set0000.set000.set020.p024

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  it should "get 2->1->4->3 after swap nodes on 1->2->3->4" in {
    val head = ListNode("1->2->3->4")
    val res = Solution.swapPairs(head)
    val str = res.toString
    str shouldEqual "2->1->4->3"
  }
}
