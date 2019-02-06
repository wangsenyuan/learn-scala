package set300.set320.p324

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[1, 3, 2, 2, 3, 1]" should "get work" in {
    val nums = Array(1, 3, 2, 2, 3, 1)

    Solution.wiggleSort(nums)

    Solution.isWiggle(nums) should be(true)
  }

  "[4,5,5,6]" should "get work" in {
    val nums = Array(4, 5, 5, 6)

    Solution.wiggleSort(nums)

    Solution.isWiggle(nums) should be(true)
  }

  "[1]" should "get work" in {
    val nums = Array(1)

    Solution.wiggleSort(nums)

    Solution.isWiggle(nums) should be(true)
  }
}
