package set0000.set400.set400.p402

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "1432219 and 3" should "get 1219" in {
    val res = Solution.removeKdigits("1432219", 3)
    res should equal("1219")
  }

  "10200 and 2" should "get 200" in {
    val res = Solution.removeKdigits("10200", 1)
    res should equal("200")
  }

  "10 and 2" should "get 0" in {
    val res = Solution.removeKdigits("10", 2)
    res should equal("0")
  }
}
