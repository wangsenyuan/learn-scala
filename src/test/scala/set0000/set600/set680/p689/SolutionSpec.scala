package set0000.set600.set680.p689

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  "example one" should "work" in {
    val res = Solution.maxSumOfThreeSubarrays(Array(1, 2, 1, 2, 6, 7, 5, 1), 2)
    res should equal(Array(0, 3, 5))
  }
}
