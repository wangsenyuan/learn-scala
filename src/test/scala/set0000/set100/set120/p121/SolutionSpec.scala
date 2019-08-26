package set0000.set100.set120.p121

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "7,1,5,3,6,4" should "get 5" in {
    val nums = Array(7, 1, 5, 3, 6, 4)
    Solution.maxProfit(nums) should be(5)
  }

  "7,6,4,3,1" should "get 0" in {
    val nums = Array(7, 6, 4, 3, 1)
    Solution.maxProfit(nums) should be(0)
  }
}
