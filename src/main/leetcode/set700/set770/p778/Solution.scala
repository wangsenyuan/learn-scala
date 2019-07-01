package set700.set770.p778

object Solution {
  val dd = Array(-1, 0, 1, 0, -1)

  def swimInWater(grid: Array[Array[Int]]): Int = {

    val n = grid.length
    val N = n * n

    val que = Array.ofDim[Int](N)
    val dist = Array.fill(N)(-1)

    def check(t: Int): Boolean = {
      if(grid(0)(0) > t) {
        false
      } else {
        (0 until N).foreach(i => dist(i) = -1)
        dist(0) = 0
        var end = 0
        var front = 0
        que(end) = 0
        end += 1
        while (front < end) {
          val cur = que(front)
          front += 1
          val x = cur / n
          val y = cur % n

          var k = 0
          while (k < 4) {
            val u = x + dd(k)
            val v = y + dd(k + 1)
            if (u >= 0 && u < n && v >= 0 && v < n && dist(u * n + v) < 0 && t >= grid(u)(v)) {
              que(end) = u * n + v
              end += 1
              dist(u * n + v) = dist(cur) + 1
            }
            k += 1
          }

        }

        dist(N - 1) >= 0
      }
    }

    var left = 0
    var right = N
    while (left < right) {
      val mid = (left + right) / 2
      if (check(mid)) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    right
  }
}
