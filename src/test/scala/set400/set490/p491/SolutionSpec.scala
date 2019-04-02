package set400.set490.p491

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val nums = Array(4, 6, 7, 7)
    val res = Solution.findSubsequences(nums)
    res should equal(List(List(4, 6), List(4, 7), List(4, 6, 7), List(4, 6, 7, 7), List(6, 7), List(6, 7, 7), List(7, 7), List(4, 7, 7)))
  }
}
