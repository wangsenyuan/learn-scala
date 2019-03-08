package set400.set410.p417

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val matrix = Array(
      Array(1, 2, 2, 3, 5),
      Array(3, 2, 3, 4, 4),
      Array(2, 4, 5, 3, 1),
      Array(6, 7, 1, 4, 5),
      Array(5, 1, 1, 2, 4),
    )
    val res = Solution.pacificAtlantic(matrix)
    res should equal(List(Array(0, 4), Array(1, 3), Array(1, 4),
      Array(2, 2), Array(3, 0), Array(3, 1), Array(4, 0)))
  }
}
