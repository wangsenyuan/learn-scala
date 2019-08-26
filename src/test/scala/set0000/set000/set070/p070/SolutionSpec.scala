package set0000.set000.set070.p070

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "3 stairs" should "get 3" in {
    val res = Solution.climbStairs(3)
    res should be(3)
  }
}
