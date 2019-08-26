package set0000.set100.set130.p130

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val board = Array(
      "XXXX".toCharArray,
      "XOOX".toCharArray,
      "XXOX".toCharArray,
      "XOXX".toCharArray,
    )
    Solution.solve(board)
    board.map(_.mkString("")).mkString("") should equal("XXXXXXXXXXXXXOXX")
  }
}
