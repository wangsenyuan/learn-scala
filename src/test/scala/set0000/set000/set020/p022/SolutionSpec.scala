package set0000.set000.set020.p022

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  it should
    """
      |get "((()))"
      |"(()())"
      |"(())()"
      |"()(())"
      |"()()()"
      |when given n = 3
    """.stripMargin in {
    val res = Solution.generateParenthesis(3)
    val expect = List("((()))",
      "(()())",
      "(())()",
      "()(())",
      "()()()",
    ).sorted
    res.sorted shouldEqual expect
  }
}
