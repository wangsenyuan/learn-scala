package set0000.set900.set990.p994

object Solution {
  val dd = Array(-1, 0, 1, 0, -1)

  def orangesRotting(grid: Array[Array[Int]]): Int = {
    val m = grid.length
    val n = grid(0).length
    val que = Array.ofDim[Int](m * n)
    val dist = Array.fill(m * n)(-1)
    var end = 0

    for {
      i <- 0 until m
      j <- 0 until n
      if grid(i)(j) == 2
    } {
      que(end) = i * n + j
      dist(i * n + j) = 0
      end += 1
    }

    var front = 0
    while (front < end) {
      val cur = que(front)
      front += 1
      val x = cur / n
      val y = cur % n

      var k = 0
      while (k < 4) {
        val u = x + dd(k)
        val v = y + dd(k + 1)
        if (u >= 0 && u < m && v >= 0 && v < n && grid(u)(v) == 1 && dist(u * n + v) < 0) {
          que(end) = u * n + v
          end += 1
          dist(u * n + v) = dist(cur) + 1
        }
        k += 1
      }
    }
    var fresh = false
    var res = 0
    for {
      i <- 0 until m
      j <- 0 until n
    } {
      res = res max dist(i * n + j)
      if (grid(i)(j) == 1 && dist(i * n + j) < 0) {
        fresh = true
      }
    }

    if (fresh) {
      -1
    } else {
      res max 0
    }
  }
}
