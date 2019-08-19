package set800.set850.p856

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.scoreOfParentheses("()")
    res should be(1)
  }

  "example two" should "work" in {
    val res = Solution.scoreOfParentheses("(())")
    res should be(2)
  }

  "example three" should "work" in {
    val res = Solution.scoreOfParentheses("((()))")
    res should be(4)
  }

  "example four" should "work" in {
    val res = Solution.scoreOfParentheses("()()")
    res should be(2)
  }

  "example five" should "work" in {
    val res = Solution.scoreOfParentheses("(()(()))")
    res should be(6)
  }
}
