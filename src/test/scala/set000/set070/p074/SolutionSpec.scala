package set000.set070.p074

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {
  "[[1,   3,  5,  7],  [10, 11, 16, 20],  [23, 30, 34, 50]]" should "has 3" in {
    val matrix = Array(
      Array(1, 3, 5, 7),
      Array(10, 11, 16, 20),
      Array(23, 30, 34, 50),
    )
    val res = Solution.searchMatrix(matrix, 3)
    res should be(true)
  }

  it should "not has 13" in {
    val matrix = Array(
      Array(1, 3, 5, 7),
      Array(10, 11, 16, 20),
      Array(23, 30, 34, 50),
    )
    val res = Solution.searchMatrix(matrix, 13)
    res should be(false)
  }
}
