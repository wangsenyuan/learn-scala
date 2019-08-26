package set0000.set200.set200.p209

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "get 2" in {
    val s = 7
    val nums = Array(2, 3, 1, 2, 4, 3)
    val res = Solution.minSubArrayLen(s, nums)
    res should be(2)
  }
}
