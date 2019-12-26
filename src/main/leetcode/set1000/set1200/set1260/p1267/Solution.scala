package set1000.set1200.set1260.p1267

object Solution {
  def countServers(grid: Array[Array[Int]]): Int = {
    val m = grid.length
    val n = grid(0).length
    val row = Array.ofDim[Int](m)
    val col = Array.ofDim[Int](n)

    for {
      i <- 0 until m
      j <- 0 until n
    } {
      row(i) += grid(i)(j)
      col(j) += grid(i)(j)
    }

    var res = 0

    for {
      i <- 0 until m
      j <- 0 until n
      if grid(i)(j) == 1
    } {
      if (row(i) > 1 || col(j) > 1) {
        res += 1
      }
    }
    res
  }
}
