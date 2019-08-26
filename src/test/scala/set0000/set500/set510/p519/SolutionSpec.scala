package set0000.set500.set510.p519

import org.scalatest.{FlatSpec, Matchers}

class SolutionSpec extends FlatSpec with Matchers {

  def validateResult(res: Array[Int], rows: Int, cols: Int, grid: Array[Array[Int]]) = {
    val x = res(0)
    val y = res(1)
    x >= 0 && x < rows && y >= 0 && y < cols && grid(x)(y) == 0
  }

  "example one" should "work" in {
    val rows = 2
    val cols = 2
    val grid = Array.ofDim[Int](2, 2)
    val solution = new Solution(rows, cols)

    for {
      i <- 0 until 4
    } {
      val res = solution.flip()
      validateResult(res, rows, cols, grid) should be(true)
      grid(res(0))(res(1)) = 1
    }
  }

  "example two" should "work" in {
    val rows = 26
    val cols = 1
    val grid = Array.ofDim[Int](rows, cols)
    val solution = new Solution(rows, cols)

    for {
      i <- 0 until 26
    } {
      val res = solution.flip()
      val check = validateResult(res, rows, cols, grid)
      check should be(true)
      grid(res(0))(res(1)) = 1
    }

    for {
      i <- 0 until rows
      j <- 0 until cols
    } {
      grid(i)(j) = 0
    }

    solution.reset()
    for {
      i <- 0 until 26
    } {
      val res = solution.flip()
      val check = validateResult(res, rows, cols, grid)
      check should be(true)
      grid(res(0))(res(1)) = 1
    }
  }
}
