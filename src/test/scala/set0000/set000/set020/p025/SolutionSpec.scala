package set0000.set000.set020.p025

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  it should "get 2->1->4->3->5 when given 1->2->3->4->5 and 2" in {
    val head = ListNode("1->2->3->4->5")
    val k = 2
    val res = Solution.reverseKGroup(head, k)
    val str = res.toString
    str shouldEqual "2->1->4->3->5"
  }

  it should "get 3->2->1->4->5 when given 1->2->3->4->5 and 3" in {
    val head = ListNode("1->2->3->4->5")
    val k = 3
    val res = Solution.reverseKGroup(head, k)
    val str = res.toString
    str shouldEqual "3->2->1->4->5"
  }

  it should "get 5->4->3->2->1 when given 1->2->3->4->5 and 5" in {
    val head = ListNode("1->2->3->4->5")
    val k = 5
    val res = Solution.reverseKGroup(head, k)
    val str = res.toString
    str shouldEqual "5->4->3->2->1"
  }

  it should "get 3->2->1->6->5->4 when given 1->2->3->4->5->6 and 3" in {
    val head = ListNode("1->2->3->4->5->6")
    val k = 3
    val res = Solution.reverseKGroup(head, k)
    val str = res.toString
    str shouldEqual "3->2->1->6->5->4"
  }

  it should "get 1->2->3->4->5->6 when given 1->2->3->4->5->6 and 1" in {
    val head = ListNode("1->2->3->4->5->6")
    val k = 1
    val res = Solution.reverseKGroup(head, k)
    val str = res.toString
    str shouldEqual "1->2->3->4->5->6"
  }
}
