package set800.set800.p805

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val nums = Array(1, 2, 3, 4, 5, 6, 7, 8)
    val res = Solution.splitArraySameAverage(nums)
    res should be(true)
  }

  "example two" should "work" in {
    val nums = Array(17, 3, 7, 12, 1)
    val res = Solution.splitArraySameAverage(nums)
    res should be(false)
  }
}
