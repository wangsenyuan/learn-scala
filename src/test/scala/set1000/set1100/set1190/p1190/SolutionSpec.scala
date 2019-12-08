package set1000.set1100.set1190.p1190

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val str = "(abcd)"
    val res = Solution.reverseParentheses(str)
    res should be("dcba")
  }

  "example two" should "work" in {
    val str = "(u(love)i)"
    val res = Solution.reverseParentheses(str)
    res should be("iloveu")
  }

  "example three" should "work" in {
    val str = "(ed(et(oc))el)"
    val res = Solution.reverseParentheses(str)
    res should be("leetcode")
  }

  "example four" should "work" in {
    val str = "a(bcdefghijkl(mno)p)q"
    val res = Solution.reverseParentheses(str)
    res should be("apmnolkjihgfedcbq")
  }

  "example five" should "work" in {
    val str = "vdgzyj()"
    val res = Solution.reverseParentheses(str)
    res should be("vdgzyj")
  }
}
