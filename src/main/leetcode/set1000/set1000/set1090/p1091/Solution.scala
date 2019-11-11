package set1000.set1000.set1090.p1091

object Solution {
  def shortestPathBinaryMatrix(grid: Array[Array[Int]]): Int = {
    if (grid(0)(0) == 1) {
      -1
    } else {
      val m = grid.length
      val n = grid(0).length
      val dist = Array.fill(m, n)(-1)
      val que = Array.ofDim[Int](m * n)
      var end = 0
      que(end) = 0
      end += 1
      dist(0)(0) = 0

      var front = 0

      while (front < end) {
        val cur = que(front)
        front += 1
        val x = cur / n
        val y = cur % n
        for {
          i <- -1 to 1
          j <- -1 to 1
          u = x + i
          v = y + j
          if u >= 0 && u < m && v >= 0 && v < n && grid(u)(v) == 0 && dist(u)(v) < 0
        } {
          que(end) = u * n + v
          end += 1
          dist(u)(v) = dist(x)(y) + 1
        }
      }

      if (dist(m - 1)(n - 1) < 0) {
        -1
      } else {
        dist(m - 1)(n - 1) + 1
      }
    }

  }
}
