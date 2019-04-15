package set500.set540.p540

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val nums = Array(1, 1, 2)
    val res = Solution.singleNonDuplicate(nums)
    res should be(2)
  }

  "example two" should "work" in {
    val nums = Array(1, 1, 2, 3, 3, 4, 4, 8, 8)
    val res = Solution.singleNonDuplicate(nums)
    res should be(2)
  }

  "example three" should "work" in {
    val nums = Array(3, 3, 7, 7, 10, 11, 11)
    val res = Solution.singleNonDuplicate(nums)
    res should be(10)
  }
}
