package set0000.set000.set060.p063

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[0,0,0],\n  [0,1,0],\n  [0,0,0]" should "have 2 unique paths" in {
    val grid = Array(
      Array(0, 0, 0),
      Array(0, 1, 0),
      Array(0, 0, 0),
    )
    val res = Solution.uniquePathsWithObstacles(grid)

    res should be(2)
  }
}
