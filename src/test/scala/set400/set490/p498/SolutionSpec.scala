package set400.set490.p498

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "work" in {
    val matrix = Array(
      Array(1, 2, 3),
      Array(4, 5, 6),
      Array(7, 8, 9),
    )
    val res = Solution.findDiagonalOrder(matrix)
    res should equal(Array(1, 2, 4, 7, 5, 3, 6, 8, 9))
  }

  "example two" should "work" in {
    val matrix = Array(
      Array(1, 2, 3),
      Array(4, 5, 6),
    )
    val res = Solution.findDiagonalOrder(matrix)
    res should equal(Array(1, 2, 4, 5, 3, 6))
  }

  "example three" should "work" in {
    val matrix = Array(
      Array(1, 2),
      Array(4, 5),
      Array(7, 8),
    )
    val res = Solution.findDiagonalOrder(matrix)
    res should equal(Array(1, 2, 4, 7, 5, 8))
  }
}
