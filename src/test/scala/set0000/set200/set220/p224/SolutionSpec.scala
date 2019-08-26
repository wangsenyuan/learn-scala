package set0000.set200.set220.p224

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "1 + 1" should "get 2" in {
    val res = Solution.calculate("1 + 1")
    res should be(2)
  }

  " 2-1 + 2 " should "get 3" in {
    val res = Solution.calculate(" 2-1 + 2 ")
    res should be(3)
  }

  "(1+(4+5+2)-3)+(6+8)" should "get 23" in {
    val res = Solution.calculate("(1+(4+5+2)-3)+(6+8)")
    res should be(23)
  }

  "0" should "get 0" in {
    val res = Solution.calculate("0")
    res should be(0)
  }
}
