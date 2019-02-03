package set300.set310.p312

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[3,1,5,8]" should "get 167" in {
    val res = Solution.maxCoins(Array(3, 1, 5, 8))
    res should be(167)
  }
}
