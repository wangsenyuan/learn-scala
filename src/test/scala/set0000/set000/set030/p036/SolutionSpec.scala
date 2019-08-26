package set0000.set000.set030.p036

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  it should "be true when test example 1" in {
    val board = Array(
      Array("5", "3", ".", ".", "7", ".", ".", ".", "."),
      Array("6", ".", ".", "1", "9", "5", ".", ".", "."),
      Array(".", "9", "8", ".", ".", ".", ".", "6", "."),
      Array("8", ".", ".", ".", "6", ".", ".", ".", "3"),
      Array("4", ".", ".", "8", ".", "3", ".", ".", "1"),
      Array("7", ".", ".", ".", "2", ".", ".", ".", "6"),
      Array(".", "6", ".", ".", ".", ".", "2", "8", "."),
      Array(".", ".", ".", "4", "1", "9", ".", ".", "5"),
      Array(".", ".", ".", ".", "8", ".", ".", "7", "9")
    )
    val board2 = board.map(row => row.map(s => s.charAt(0)))
    val res = Solution.isValidSudoku(board2)
    res shouldBe true
  }
}
