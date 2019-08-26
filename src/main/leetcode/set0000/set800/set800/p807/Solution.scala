package set0000.set800.set800.p807

object Solution {
  def maxIncreaseKeepingSkyline(grid: Array[Array[Int]]): Int = {
    val m = grid.length
    if (m == 0) {
      0
    } else {
      val n = grid(0).length
      if (n == 0) {
        0
      } else {
        val row = Array.ofDim[Int](n)
        val col = Array.ofDim[Int](n)
        for {
          i <- 0 until m
          j <- 0 until n
        } {
          row(i) = row(i) max grid(i)(j)
          col(j) = col(j) max grid(i)(j)
        }

        var res = 0
        for {
          i <- 0 until m
          j <- 0 until n
        } {
          res += (row(i) - grid(i)(j)) min (col(j) - grid(i)(j))
        }

        res
      }
    }
  }
}
