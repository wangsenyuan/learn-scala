package set0000.set700.set720.p724

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val nums = Array(1, 7, 3, 6, 5, 6)
    val res = Solution.pivotIndex(nums)
    res should equal(3)
  }
}
