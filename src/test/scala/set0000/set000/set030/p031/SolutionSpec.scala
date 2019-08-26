package set0000.set000.set030.p031

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  it should "get [1, 5, 1] when given [1, 1, 5]" in {
    val nums = Array(1, 1, 5)
    Solution.nextPermutation(nums)
    nums shouldEqual Array(1, 5, 1)
  }

  it should "get [1, 3, 2] when given [1, 2, 3]" in {
    val nums = Array(1, 2, 3)
    Solution.nextPermutation(nums)
    nums shouldEqual Array(1, 3, 2)
  }

  it should "get [2,3,3,1,3] when given [2,3,1,3,3]" in {
    val nums = Array(2,3,1,3,3)
    Solution.nextPermutation(nums)
    nums shouldEqual Array(2,3,3,1,3)
  }
}
