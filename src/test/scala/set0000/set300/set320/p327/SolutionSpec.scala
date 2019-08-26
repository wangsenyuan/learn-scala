package set0000.set300.set320.p327

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "nums = [-2,5,-1], lower = -2, upper = 2" should "get 3" in {
    val nums = Array(-2, 5, -1)
    val lower = -2
    val upper = 2
    val res = Solution.countRangeSum(nums, lower, upper)
    res should be(3)
  }

  "nums = [], lower = 0, upper = 0" should "get 0" in {
    val nums = Array.empty[Int]
    val lower = 0
    val upper = 0
    val res = Solution.countRangeSum(nums, lower, upper)
    res should be(0)
  }

  "nums = [0,-3,-3,1,1,2], lower = 3, upper = 5" should "get 2" in {
    val nums = Array(0, -3, -3, 1, 1, 2)
    val lower = 3
    val upper = 5
    val res = Solution.countRangeSum(nums, lower, upper)
    res should be(2)
  }
}
