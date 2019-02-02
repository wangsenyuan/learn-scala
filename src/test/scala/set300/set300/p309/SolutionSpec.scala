package set300.set300.p309

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "1,2,3,0,2" should "get 3" in {
    val res = Solution.maxProfit(Array(1, 2, 3, 0, 2))
    res should be(3)
  }

  "1,2,4" should "get 3" in {
    val res = Solution.maxProfit(Array(1, 2, 4))
    res should be(3)
  }

  "6,1,3,2,4,7" should "get 6" in {
    val res = Solution.maxProfit(Array(6, 1, 3, 2, 4, 7))
    res should be(6)
  }
}
