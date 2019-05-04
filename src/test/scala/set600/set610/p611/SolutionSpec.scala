package set600.set610.p611

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val nums = Array(2, 2, 3, 4)
    val res = Solution.triangleNumber(nums)
    res should be(3)
  }
}
