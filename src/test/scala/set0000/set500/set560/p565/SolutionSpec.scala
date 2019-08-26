package set0000.set500.set560.p565

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  "example one" should "work" in {
    val nums = Array(5, 4, 0, 3, 1, 6, 2)
    val res = Solution.arrayNesting(nums)
    res should be(4)
  }

  "example two" should "work" in {
    val nums = Array(0, 1, 2, 3, 4, 5)
    val res = Solution.arrayNesting(nums)
    res should be(1)
  }
}
