package set0000.set500.set580.p581

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val nums = Array(2, 6, 4, 8, 10, 9, 15)
    val res = Solution.findUnsortedSubarray(nums)
    res should be(5)
  }

  "example two" should "work" in {
    val nums = Array(0, 1, 2, 3, 4)
    val res = Solution.findUnsortedSubarray(nums)
    res should be(0)
  }

  "example three" should "work" in {
    val nums = Array(1, 3, 2, 2, 2)
    val res = Solution.findUnsortedSubarray(nums)
    res should be(4)
  }
}
