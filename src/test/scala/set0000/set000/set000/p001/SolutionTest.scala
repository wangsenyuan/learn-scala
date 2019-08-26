package set0000.set000.set000.p001

import org.scalatest.{FlatSpec, Matchers}

class SolutionTest extends FlatSpec with Matchers {

  it should "get correct answer" in {
    val nums = Array(2, 7, 11, 15)
    val target = 9
    val expect = Array(0, 1)
    val res = Solution.twoSum(nums, target)
    res shouldEqual expect
  }
}
