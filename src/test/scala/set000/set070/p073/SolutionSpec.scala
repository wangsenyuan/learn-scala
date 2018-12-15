package set000.set070.p073

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  "[1,1,1],[1,0,1],[1,1,1]" should "result [1,0,1],[0,0,0],[1,0,1]" in {
    val matrix = Array(
      Array(1, 1, 1),
      Array(1, 0, 1),
      Array(1, 1, 1),
    )
    Solution.setZeroes(matrix)

    matrix(0)(0) should be(1)
    matrix(0)(1) should be(0)
    matrix(0)(2) should be(1)
    matrix(1)(0) should be(0)
    matrix(2)(1) should be(0)
  }

  "[0,1,2,0], [3,4,5,2], [1,3,1,5]" should "result [0,0,0,0],[0,4,5,0],[0,3,1,0]" in {
    val matrix = Array(
      Array(0, 1, 2, 0),
      Array(3, 4, 5, 2),
      Array(1, 3, 1, 5),
    )
    Solution.setZeroes(matrix)

    matrix(1)(0) should be(0)
    matrix(2)(0) should be(0)
    matrix(1)(1) should be(4)
    matrix(2)(3) should be(0)
  }
}
