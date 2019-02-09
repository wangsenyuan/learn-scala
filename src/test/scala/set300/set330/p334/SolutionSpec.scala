package set300.set330.p334

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[0,4,2,1,0,-1,-3]" should "get false" in {
    val nums = Array(0, 4, 2, 1, 0, -1, -3)
    Solution.increasingTriplet(nums) should be(false)
  }
}
