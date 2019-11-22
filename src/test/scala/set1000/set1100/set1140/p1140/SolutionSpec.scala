package set1000.set1100.set1140.p1140

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "match" in {
    val res = Solution.stoneGameII(Array(2, 7, 9, 4, 4))
    res should be(10)
  }
}
