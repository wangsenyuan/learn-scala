package set0000.set700.set770.p773

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val board = Array(Array(1, 2, 3), Array(4, 0, 5))
    val res = Solution.slidingPuzzle(board)
    res should be(1)
  }

  "example two" should "work" in {
    val board = Array(Array(1, 2, 3), Array(5, 4, 0))
    val res = Solution.slidingPuzzle(board)
    res should be(-1)
  }

  "example three" should "work" in {
    val board = Array(Array(4, 1, 2), Array(5, 0, 3))
    val res = Solution.slidingPuzzle(board)
    res should be(5)
  }

  "example four" should "work" in {
    val board = Array(Array(3, 2, 4), Array(1, 5, 0))
    val res = Solution.slidingPuzzle(board)
    res should be(14)
  }
}
