package set000.set040.p041

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  it should "get 3 when given [1, 2, 0]" in {
    val nums = Array(1, 2, 0)
    val res = Solution.firstMissingPositive(nums)
    res shouldBe 3
  }

  it should "get 2 when given [3, 4, -1, 1]" in {
    val nums = Array(3, 4, -1, 1)
    val res = Solution.firstMissingPositive(nums)
    res shouldBe 2
  }

  it should "get 1 when given [7,8,9,11,12]" in {
    val nums = Array(7, 8, 9, 11, 12)
    val res = Solution.firstMissingPositive(nums)
    res shouldBe 1
  }
}
