package set0000.set200.set220.p227

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "3+2*2" should "get 7" in {
    val res = Solution.calculate("3+2*2")
    res should be(7)
  }

  "3/2" should "get 1" in {
    val res = Solution.calculate("3/2")
    res should be(1)
  }

  " 3+5 / 2 " should "get 2" in {
    val res = Solution.calculate(" 3+5 / 2 ")
    res should be(5)
  }

  "1*2-3/4+5*6-7*8+9/10" should "get 0" in {
    val res = Solution.calculate("1*2-3/4+5*6-7*8+9/10")
    res should be(-24)
  }
}
