package set200.set230.p234

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "1->2->2->1" should "be true" in {
    val head = new ListNode(1)
    head.next = new ListNode(2)
    head.next.next = new ListNode(2)
    head.next.next.next = new ListNode(1)
    val res = Solution.isPalindrome(head)
    res should be(true)
  }

  "1->2->3->2->1" should "be true" in {
    val head = new ListNode(1)
    head.next = new ListNode(2)
    head.next.next = new ListNode(3)
    head.next.next.next = new ListNode(2)
    head.next.next.next.next = new ListNode(1)
    val res = Solution.isPalindrome(head)
    res should be(true)
  }

  "1->2->3->2->2" should "be false" in {
    val head = new ListNode(1)
    head.next = new ListNode(2)
    head.next.next = new ListNode(3)
    head.next.next.next = new ListNode(2)
    head.next.next.next.next = new ListNode(2)
    val res = Solution.isPalindrome(head)
    res should be(false)
  }
}
