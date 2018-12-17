package set000.set080.p080

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "given [1,1,1,2,2,3]" should "get [1, 1, 2, 2, 3]" in {
    val nums = Array(1, 1, 1, 2, 2, 3)
    val n = Solution.removeDuplicates(nums)
    nums.slice(0, n) should equal(Array(1, 1, 2, 2, 3))
  }

  "given [0,0,1,1,1,1,2,3,3]" should "get [0, 0, 1, 1, 2, 3, 3]" in {
    val nums = Array(0, 0, 1, 1, 1, 1, 2, 3, 3)
    val n = Solution.removeDuplicates(nums)
    nums.slice(0, n) should equal(Array(0, 0, 1, 1, 2, 3, 3))
  }
}
