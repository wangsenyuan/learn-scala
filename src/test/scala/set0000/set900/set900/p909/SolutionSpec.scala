package set0000.set900.set900.p909

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val board = Array(
      Array(-1, -1, -1, -1, -1, -1),
      Array(-1, -1, -1, -1, -1, -1),
      Array(-1, -1, -1, -1, -1, -1),
      Array(-1, 35, -1, -1, 13, -1),
      Array(-1, -1, -1, -1, -1, -1),
      Array(-1, 15, -1, -1, -1, -1),
    )
    val res = Solution.snakesAndLadders(board)

    res should be(4)
  }

  "example two" should "work" in {
    val board = Array(
      Array(-1, 4, -1), Array(6, 2, 6), Array(-1, 3, -1),
    )
    val res = Solution.snakesAndLadders(board)

    res should be(2)
  }

  "example three" should "work" in {
    val board = Array(
      Array(1, 1, -1), Array(1, 1, 1), Array(-1, 1, 1),
    )
    val res = Solution.snakesAndLadders(board)

    res should be(-1)
  }
}
