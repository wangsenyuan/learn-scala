package set0000.set800.set820.p823

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val nums = Array(2, 4, 5, 10)
    val res = Solution.numFactoredBinaryTrees(nums)

    res should be(7)
  }
}
