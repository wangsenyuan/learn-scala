package set0000.set300.set320.p329

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "example one" should "get 4" in {
    val matrix = Array(
      Array(9, 9, 4),
      Array(6, 6, 8),
      Array(2, 1, 1)
    )
    val res = Solution.longestIncreasingPath(matrix)
    res should equal(4)
  }

  "example two" should "get 4" in {
    val matrix = Array(
      Array(3, 4, 5),
      Array(3, 2, 6),
      Array(2, 2, 1)
    )
    val res = Solution.longestIncreasingPath(matrix)
    res should equal(4)
  }

  "example three" should "get 5" in {
    val matrix = Array(
      Array(3, 4, 5),
      Array(3, 2, 6),
      Array(2, 1, 1)
    )
    val res = Solution.longestIncreasingPath(matrix)
    res should equal(5)
  }
}
