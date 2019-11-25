package set1000.set1100.set1160.p1162

object Solution {
  val dd = Array(-1, 0, 1, 0, - 1)

  def maxDistance(grid: Array[Array[Int]]): Int = {
    val m = grid.length
    val n = grid(0).length

    val que = Array.ofDim[Int](m * n)
    val dist = Array.fill(m * n)(-1)

    var end = 0
    for {
      i <- 0 until m
      j <- 0 until n
      if grid(i)(j) == 1
    } {
      que(end) = i * n + j
      end += 1
      dist(i * n + j) = 0
    }

    if (end == 0 || end == m * n) {
      // no ones
      -1
    } else {
      var front = 0
      while (front < end) {
        val cur = que(front)
        front += 1
        val x = cur / n
        val y = cur % n
        for {
          k <- 0 until 4
        } {
          val u = x + dd(k)
          val v = y + dd(k + 1)
          if (u >= 0 && u < m && v >= 0 && v < n && grid(u)(v) == 0 && dist(u * n + v) < 0) {
            dist(u * n + v) = dist(cur) + 1
            que(end) = u * n + v
            end += 1
          }
        }
      }
      dist.max
    }
  }
}
