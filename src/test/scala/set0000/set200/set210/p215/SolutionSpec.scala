package set0000.set200.set210.p215

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[3,2,1,5,6,4]" should "get 6 when k = 1" in {
    val nums = Array(3, 2, 1, 5, 6, 4)

    val res = Solution.findKthLargest(nums, 1)
    res should be(6)
  }

  it should "get 5 when k = 2" in {
    val nums = Array(3, 2, 1, 5, 6, 4)
    val res = Solution.findKthLargest(nums, 2)
    res should be(5)
  }

  it should "get 4 when k = 3" in {
    val nums = Array(3, 2, 1, 5, 6, 4)

    val res = Solution.findKthLargest(nums, 3)
    res should be(4)
  }
}
