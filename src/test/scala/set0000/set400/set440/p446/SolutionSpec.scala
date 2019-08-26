package set0000.set400.set440.p446

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "2, 4, 6, 8, 10" should "get 7" in {
    val nums = Array(2, 4, 6, 8, 10)
    val res = Solution.numberOfArithmeticSlices(nums)
    res should be(7)
  }

  "0, 1, 2, 2, 2" should "get 4" in {
    val nums = Array(0, 1, 2, 2, 2)
    val res = Solution.numberOfArithmeticSlices(nums)
    res should be(4)
  }


  "example 3" should "work" in {
    val nums = Array(79, 20, 64, 28, 67, 81, 60, 58, 97, 85, 92, 96, 82, 89, 46, 50, 15, 2, 36, 44, 54, 2, 90, 37, 7, 79, 26, 40, 34, 67, 64, 28, 60, 89, 46, 31, 9, 95, 43, 19, 47, 64, 48, 95, 80, 31, 47, 19, 72, 99, 28, 46, 13, 9, 64, 4, 68, 74, 50, 28, 69, 94, 93, 3, 80, 78, 23, 80, 43, 49, 77, 18, 68, 28, 13, 61, 34, 44, 80, 70, 55, 85, 0, 37, 93, 40, 47, 47, 45, 23, 26, 74, 45, 67, 34, 20, 33, 71, 48, 96)
    val res = Solution.numberOfArithmeticSlices(nums)
    res should be(1030)
  }
}
