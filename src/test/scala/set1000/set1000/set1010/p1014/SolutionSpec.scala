package set1000.set1000.set1010.p1014

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val arr = Array(1, 3, 5)
    val res = Solution.maxScoreSightseeingPair(arr)
    res should be(7)
  }
}
