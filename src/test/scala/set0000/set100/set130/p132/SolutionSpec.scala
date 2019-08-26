package set0000.set100.set130.p132

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "aab" should "get 1" in {
    val res = Solution.minCut("aab")
    res should be(1)
  }
}
