package set0000.set000.set090.p092

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  "1->2->3->4->5" should "be 1->4->3->2->5 after reverse between 2 & 4" in {
    val head = ListNode("1->2->3->4->5")
    val res = Solution.reverseBetween(head, 2, 4)
    val s = res.toString
    s should equal("1->4->3->2->5")
  }

  it should "be 4->3->2->1->5 after reverse between 1 & 4" in {
    val head = ListNode("1->2->3->4->5")
    val res = Solution.reverseBetween(head, 1, 4)
    val s = res.toString
    s should equal("4->3->2->1->5")
  }


  it should "be 5->4->3->2->1 after reverse between 1 & 5" in {
    val head = ListNode("1->2->3->4->5")
    val res = Solution.reverseBetween(head, 1, 5)
    val s = res.toString
    s should equal("5->4->3->2->1")
  }

  it should "be 1->2->3->4->5 after reverse between 1 & 1" in {
    val head = ListNode("1->2->3->4->5")
    val res = Solution.reverseBetween(head, 1, 1)
    val s = res.toString
    s should equal("1->2->3->4->5")
  }

  it should "be 2->1->3->4->5 after reverse between 1 & 2" in {
    val head = ListNode("1->2->3->4->5")
    val res = Solution.reverseBetween(head, 1, 2)
    val s = res.toString
    s should equal("2->1->3->4->5")
  }
}
