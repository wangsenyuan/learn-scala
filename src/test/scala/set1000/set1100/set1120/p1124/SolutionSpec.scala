package set1000.set1100.set1120.p1124

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val hours = Array(6, 6, 9, 6, 9, 9, 6, 0, 6, 6, 9)
    val res = Solution.longestWPI(hours)
    res should be(5)
  }
}
