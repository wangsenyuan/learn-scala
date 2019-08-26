package set0000.set400.set460.p463

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val grid = Array(
      Array(0, 1, 0, 0),
      Array(1, 1, 1, 0),
      Array(0, 1, 0, 0),
      Array(1, 1, 0, 0))
    val res = Solution.islandPerimeter(grid)

    res should be(16)
  }
}
