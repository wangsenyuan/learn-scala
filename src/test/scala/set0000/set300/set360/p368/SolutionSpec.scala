package set0000.set300.set360.p368

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[1,2,4,8]" should "get [1,2,4,8]" in {
    val res = Solution.largestDivisibleSubset(Array(1, 2, 4, 8))
    res should equal(List(1, 2, 4, 8))
  }
}
