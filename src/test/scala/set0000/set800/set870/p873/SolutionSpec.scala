package set0000.set800.set870.p873

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.lenLongestFibSubseq(Array(1, 2, 3, 4, 5, 6, 7, 8))
    res should be(5)
  }
}
