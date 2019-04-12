package set500.set520.p529

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers{
  "example one" should "work" in {
    val board = Array(
      Array('E', 'E', 'E'),
      Array('E', 'E', 'E'),
      Array('E', 'E', 'E'),
    )
    val res = Solution.updateBoard(board, Array(0, 0))

    val expect = Array(
      Array('B', 'B', 'B'),
      Array('B', 'B', 'B'),
      Array('B', 'B', 'B'),
    )

    res should equal(expect)
  }

  "example two" should "work" in {
    val board = Array(
      Array('E', 'E', 'E', 'E'),
      Array('E', 'E', 'E', 'E'),
      Array('E', 'E', 'E', 'E'),
      Array('E', 'E', 'E', 'E'),
    )
    val res = Solution.updateBoard(board, Array(2, 2))

    val expect = Array(
      Array('B', 'B', 'B', 'B'),
      Array('B', 'B', 'B', 'B'),
      Array('B', 'B', 'B', 'B'),
      Array('B', 'B', 'B', 'B'),
    )

    res should equal(expect)
  }
}
