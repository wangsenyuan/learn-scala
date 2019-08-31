package set0000.set800.set890.p892

object Solution {
  val dd = Array(-1, 0, 1, 0, -1)

  def surfaceArea(grid: Array[Array[Int]]): Int = {
    var res = 0

    for {
      i <- 0 until grid.length
      j <- 0 until grid(0).length
    } {
      // top and bottom
      if (grid(i)(j) > 0) {
        res += 2

        var k = 0
        while (k < 4) {
          val u = i + dd(k)
          val v = j + dd(k + 1)
          if (u >= 0 && u < grid.length && v >= 0 && v < grid(0).length) {
            res += 0 max (grid(i)(j) - grid(u)(v))
          } else {
            res += grid(i)(j)
          }
          k += 1
        }
      }
    }

    res
  }
}
