package set1000.set1000.set1070.p1079

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.numTilePossibilities("AAB")
    res should be(8)
  }

  "example two" should "work" in {
    val res = Solution.numTilePossibilities("AAABBC")
    res should be(188)
  }
}
