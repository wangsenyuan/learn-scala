package set000.set030.p039

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  it should "get [[7], [2,2,3]] when given [2, 3, 6, 7] and 7" in {
    val nums = Array(2, 3, 6, 7)
    val target = 7
    val res = Solution.combinationSum(nums, target)
    res.size shouldEqual 2
  }

  it should "get a 3 elements result when given [2, 3, 5] and 8" in {
    val nums = Array(2, 3, 5)
    val target = 8
    val res = Solution.combinationSum(nums, target)
    res.size shouldEqual 3
  }
}
