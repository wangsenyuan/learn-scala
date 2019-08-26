package set0000.set400.set450.p457

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[2,-1,1,2,2]" should "be true" in {
    val nums = Array(2, -1, 1, 2, 2)
    val res = Solution.circularArrayLoop(nums)
    res should be(true)
  }

  "[-2,1,-1,-2,-2]" should "be false" in {
    val nums = Array(-2, 1, -1, -2, -2)
    val res = Solution.circularArrayLoop(nums)
    res should be(false)
  }

  "[-8,-1,1,7,2]" should "be false" in {
    val nums = Array(-8,-1,1,7,2)
    val res = Solution.circularArrayLoop(nums)
    res should be(false)
  }

  "[-1, 2]" should "be false" in {
    val nums = Array(-1, 2)
    val res = Solution.circularArrayLoop(nums)
    res should be(false)
  }
}
