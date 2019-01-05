package set100.set160.p167

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[2,7,11,15] and 9" should "get [1, 2]" in {
    val nums = Array(2, 7, 11, 15)
    val res = Solution.twoSum(nums, 9)
    res should equal(Array(1, 2))
  }
}
