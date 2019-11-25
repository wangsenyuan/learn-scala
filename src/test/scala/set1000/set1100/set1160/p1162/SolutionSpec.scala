package set1000.set1100.set1160.p1162

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val grid = Array(Array(1, 0, 1), Array(0, 0, 0), Array(1, 0, 1))
    val res = Solution.maxDistance(grid)
    res should be(2)
  }
}
