package set0000.set200.set280.p289

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[[0,1,0],[0,0,1],[1,1,1],[0,0,0]]" should "get [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]" in {
    val board = Array(Array(0, 1, 0), Array(0, 0, 1), Array(1, 1, 1), Array(0, 0, 0))
    Solution.gameOfLife(board)
    board(0) should equal(Array(0, 0, 0))
    board(1) should equal(Array(1, 0, 1))
    board(2) should equal(Array(0, 1, 1))
    board(3) should equal(Array(0, 1, 0))
  }
}
