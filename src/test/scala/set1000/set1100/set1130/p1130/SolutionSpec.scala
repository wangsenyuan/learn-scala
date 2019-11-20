package set1000.set1100.set1130.p1130

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val res = Solution.mctFromLeafValues(Array(6, 2, 4))
    res should be(32)
  }
}
