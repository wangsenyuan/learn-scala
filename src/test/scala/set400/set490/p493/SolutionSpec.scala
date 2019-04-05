package set400.set490.p493

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "1,3,2,3,1" should "get 2" in {
    val nums = Array(1, 3, 2, 3, 1)
    val res = Solution.reversePairs(nums)
    res should be(2)
  }

  "2,4,3,5,1" should "get 3" in {
    val nums = Array(2, 4, 3, 5, 1)
    val res = Solution.reversePairs(nums)
    res should be(3)
  }

  "-5, -5" should "get 1" in {
    val nums = Array(-5, -5)
    val res = Solution.reversePairs(nums)
    res should be(1)
  }

  "example four" should "get 0" in {
    val nums = Array(2147483647,2147483647,2147483647,2147483647,2147483647,2147483647)
    val res = Solution.reversePairs(nums)
    res should be(0)
  }
}
