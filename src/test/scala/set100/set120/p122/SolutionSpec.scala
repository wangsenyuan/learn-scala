package set100.set120.p122

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "7,1,5,3,6,4" should "get 7" in {
    val prices = Array(7, 1, 5, 3, 6, 4)
    Solution.maxProfit(prices) should be(7)
  }

  "1,2,3,4,5" should "get 4" in {
    val prices = Array(1, 2, 3, 4, 5)
    Solution.maxProfit(prices) should be(4)
  }

  "7,6,4,3,1" should "get 0" in {
    val prices = Array(7, 6, 4, 3, 1)
    Solution.maxProfit(prices) should be(0)
  }

  "3,2,6,5,0,3" should "get 7" in {
    val prices = Array(3, 2, 6, 5, 0, 3)
    Solution.maxProfit(prices) should be(7)
  }
}
