package set0000.set900.set980.p980

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val grid = Array(Array(1, 0, 0, 0), Array(0, 0, 0, 0), Array(0, 0, 2, -1))
    val res = Solution.uniquePathsIII(grid)
    res should be(2)
  }
}
