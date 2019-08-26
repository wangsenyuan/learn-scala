package set0000.set800.set820.p827

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val grid = Array(Array(1, 0), Array(0, 1))
    val res = Solution.largestIsland(grid)
    res should be(3)
  }
}
