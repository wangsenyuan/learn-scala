package set700.set790.p795

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.numSubarrayBoundedMax(Array(2, 1, 4, 3), 2, 3)
    res should be(3)
  }

  "example two" should "work" in {
    val res = Solution.numSubarrayBoundedMax(Array(1, 2, 3, 4), 2, 3)
    res should be(5)
  }

  "example three" should "work" in {
    val res = Solution.numSubarrayBoundedMax(Array(4, 3, 2, 1), 2, 3)
    res should be(5)
  }

  "example four" should "work" in {
    val res = Solution.numSubarrayBoundedMax(Array(73, 55, 36, 5, 55, 14, 9, 7, 72, 52), 32, 69)
    res should be(22)
  }
}
