package set0000.set900.set960.p964

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.leastOpsExpressTarget(3, 19)
    res should be(5)
  }

  "example two" should "work" in {
    val res = Solution.leastOpsExpressTarget(5, 501)
    res should be(8)
  }

  "example three" should "work" in {
    val res = Solution.leastOpsExpressTarget(100, 100000000)
    res should be(3)
  }

  "example four" should "work" in {
    val res = Solution.leastOpsExpressTarget(103, 32034350)
    res should be(221)
  }

  "example five" should "work" in {
    val res = Solution.leastOpsExpressTarget(11, 500041)
    res should be(41)
  }
}
