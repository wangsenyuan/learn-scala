package set100.set150.p150

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[\"2\", \"1\", \"+\", \"3\", \"*\"]" should "get 9" in {
    val res = Solution.evalRPN(Array("2", "1", "+", "3", "*"))
    res should be(9)
  }

  "[\"4\", \"13\", \"5\", \"/\", \"+\"]" should "get 6" in {
    val res = Solution.evalRPN(Array("4", "13", "5", "/", "+"))
    res should be(6)
  }

  "\"10\", \"6\", \"9\", \"3\", \"+\", \"-11\", \"*\", \"/\", \"*\", \"17\", \"+\", \"5\", \"+\"" should "get 22" in {
    val res = Solution.evalRPN(Array("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"))
    res should be(22)
  }
}
