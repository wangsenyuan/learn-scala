package set000.set060.p064

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[1,3,1],\n  [1,5,1],\n  [4,2,1]" should "get get 7" in {
    val grid = Array(
      Array(1, 3, 1),
      Array(1, 5, 1),
      Array(4, 2, 1),
    )
    val res = Solution.minPathSum(grid)

    res should be(7)
  }
}
