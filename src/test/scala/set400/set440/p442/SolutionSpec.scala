package set400.set440.p442

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val nums = Array(4, 3, 2, 7, 8, 2, 3, 1)
    val res = Solution.findDuplicates(nums)
    res should be(List(2, 3))
  }
}
