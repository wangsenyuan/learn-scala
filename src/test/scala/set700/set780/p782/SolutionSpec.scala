package set700.set780.p782

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val grid = Array(Array(0, 1, 1, 0), Array(0, 1, 1, 0), Array(1, 0, 0, 1), Array(1, 0, 0, 1))
    val res = Solution.movesToChessboard(grid)
    res should be(2)
  }

  "example two" should "work" in {
    val grid = Array(Array(0, 1), Array(1, 0))
    val res = Solution.movesToChessboard(grid)
    res should be(0)
  }

  "example three" should "work" in {
    val grid = Array(Array(1, 0), Array(1, 0))
    val res = Solution.movesToChessboard(grid)
    res should be(-1)
  }

  "example four" should "work" in {
    val grid = Array(Array(1, 1, 0), Array(0, 0, 1), Array(0, 0, 1))
    val res = Solution.movesToChessboard(grid)
    res should be(2)
  }

  "example five" should "work" in {
    val grid = Array(
      Array(0, 0, 1, 0, 1, 1),
      Array(1, 1, 0, 1, 0, 0),
      Array(1, 1, 0, 1, 0, 0),
      Array(0, 0, 1, 0, 1, 1),
      Array(1, 1, 0, 1, 0, 0),
      Array(0, 0, 1, 0, 1, 1),
    )
    val res = Solution.movesToChessboard(grid)
    res should be(2)
  }

  "example six" should "work" in {
    val grid = Array(
      Array(1, 0, 0, 1, 1),
      Array(0, 1, 1, 0, 0),
      Array(1, 0, 0, 1, 1),
      Array(0, 1, 1, 0, 0),
      Array(0, 1, 1, 0, 0),
    )
    val res = Solution.movesToChessboard(grid)
    res should be(3)
  }
}
