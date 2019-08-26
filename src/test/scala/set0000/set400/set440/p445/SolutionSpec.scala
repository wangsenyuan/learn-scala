package set0000.set400.set440.p445

import org.scalatest.{FlatSpec, Matchers}
import set0000.set400.set440.p445.Solution.ListNode

class SolutionSpec extends FlatSpec with Matchers {

  "example one" should "work" in {
    val a = new ListNode(7)
    a.next = new ListNode(2)
    a.next.next = new ListNode(4)
    a.next.next.next = new ListNode(3)
    val b = new ListNode(5)
    b.next = new ListNode(6)
    b.next.next = new ListNode(4)
    val c = Solution.addTwoNumbers(a, b)
    c.x should equal(7)
    c.next.x should equal(8)
    c.next.next.x should equal(0)
    c.next.next.next.x should equal(7)
  }
}
