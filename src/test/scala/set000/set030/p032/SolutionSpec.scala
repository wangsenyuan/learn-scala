package set000.set030.p032

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  it should "get 2 when given (()" in {
    val str = "(()"
    val res = Solution.longestValidParentheses(str)
    res shouldBe 2
  }

  it should "get 4 when given )()())" in {
    val str = ")()())"
    val res = Solution.longestValidParentheses(str)
    res shouldBe 4
  }

  it should "get 6 when given ()()())" in {
    val str = "()()())"
    val res = Solution.longestValidParentheses(str)
    res shouldBe 6
  }

  it should "get 6 when given ()(())" in {
    val str = "()(())"
    val res = Solution.longestValidParentheses(str)
    res shouldBe 6
  }
}
