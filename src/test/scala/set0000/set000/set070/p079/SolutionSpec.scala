package set0000.set000.set070.p079

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  val board1 = Array(
    Array('A', 'B', 'C', 'E'),
    Array('S', 'F', 'C', 'S'),
    Array('A', 'D', 'E', 'E'),
  )

  "board ['A','B','C','E'],['S','F','C','S'], ['A','D','E','E']" should "have ABCCED" in {
    Solution.exist(board1, "ABCCED") should be(true)
  }

  it should "have SEE" in {
    Solution.exist(board1, "SEE") should be(true)
  }

  it should "not have ABCB" in {
    Solution.exist(board1, "ABCB") should be(false)
  }

  val board2 = Array(
    Array('a')
  )

  "board ['a']" should "have 'a'" in {
    Solution.exist(board2, "a") should be(true)
  }

  val board3 = Array(
    Array("A", "B", "C", "E").map(_.charAt(0)),
    Array("S", "F", "E", "S").map(_.charAt(0)),
    Array("A", "D", "E", "E").map(_.charAt(0)),
  )

  "board3" should "have ABCEFSADEESE" in {
    Solution.exist(board3, "ABCEFSADEESE") should be(true)
  }
}
