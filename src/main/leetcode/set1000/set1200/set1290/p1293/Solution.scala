package set1000.set1200.set1290.p1293

object Solution {
  val dd = Array(-1, 0, 1, 0, -1)

  def shortestPath(grid: Array[Array[Int]], k: Int): Int = {
    val m = grid.length
    val n = grid(0).length

    val dist = Array.fill(m, n, k + 1)(-1)

    var res = 1 << 20
    dist(0)(0)(0) = 0

    val que = Array.ofDim[Int](m * n * (k + 1))
    var end = 0
    que(end) = 0
    end += 1
    var front = 0
    while (front < end) {
      val cur = que(front)
      front += 1
      val x = cur / (n * (k + 1))
      val y = (cur % (n * (k + 1))) / (k + 1)
      val z = cur % (k + 1)

      if (x == m - 1 && y == n - 1) {
        res = res min dist(x)(y)(z)
      }

      var i = 0
      while (i < 4) {
        val u = x + dd(i)
        val v = y + dd(i + 1)
        if (u >= 0 && u < m && v >= 0 && v < n) {
          if (grid(u)(v) == 0 && dist(u)(v)(z) < 0) {
            dist(u)(v)(z) = dist(x)(y)(z) + 1
            que(end) = u * n * (k + 1) + v * (k + 1) + z
            end += 1
          } else if (z < k && grid(u)(v) == 1 && dist(u)(v)(z + 1) < 0) {
            dist(u)(v)(z + 1) = dist(x)(y)(z) + 1
            que(end) = u * n * (k + 1) + v * (k + 1) + z + 1
            end += 1
          }
        }

        i += 1
      }
    }

    if (res >= (1 << 20)) {
      -1
    } else {
      res
    }
  }
}
