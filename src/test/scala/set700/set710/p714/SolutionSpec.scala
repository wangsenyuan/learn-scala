package set700.set710.p714

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val prices = Array(1, 3, 2, 8, 4, 9)
    val fee = 2
    val res = Solution.maxProfit(prices, fee)
    res should be(8)
  }
}
