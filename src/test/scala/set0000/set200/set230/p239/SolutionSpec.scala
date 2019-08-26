package set0000.set200.set230.p239

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[1,3,-1,-3,5,3,6,7] and 3" should "get [3,3,5,5,6,7] " in {
    val nums = Array(1, 3, -1, -3, 5, 3, 6, 7)
    val res = Solution.maxSlidingWindow(nums, 3)
    res should equal(Array(3, 3, 5, 5, 6, 7))
  }
}
