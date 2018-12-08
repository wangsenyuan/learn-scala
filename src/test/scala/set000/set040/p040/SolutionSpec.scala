package set000.set040.p040

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  it should "get a 4 elements result when work with example 1" in {
    val nums = Array(10, 1, 2, 7, 6, 1, 5)
    val target = 8
    val res = Solution.combinationSum2(nums, target)
    res.size shouldEqual 4
  }
}
