package set400.set480.p480

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val nums = Array(1, 3, -1, -3, 5, 3, 6, 7)
    val res = Solution.medianSlidingWindow(nums, 3)
    res should equal(Array(1.0, -1.0, -1.0, 3.0, 5.0, 6.0))
  }

  "example two" should "work" in {
    val nums = Array(1, 2)
    val res = Solution.medianSlidingWindow(nums, 1)
    res should equal(Array(1.0, 2.0))
  }

  "example three" should "work" in {
    val nums = Array(2147483647,2147483647)
    val res = Solution.medianSlidingWindow(nums, 2)
    res should equal(Array(2147483647.0))
  }
}
