package set000.set050.p055

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  "[2,3,1,1,4]" should "be able to jump at last position" in {
    val nums = Array(2, 3, 1, 1, 4)
    val res = Solution.canJump(nums)
    res shouldBe true
  }

  "[3,2,1,0,4]" should "be not able to jump at last position" in {
    val nums = Array(3, 2, 1, 0, 4)
    val res = Solution.canJump(nums)
    res shouldBe false
  }
}
