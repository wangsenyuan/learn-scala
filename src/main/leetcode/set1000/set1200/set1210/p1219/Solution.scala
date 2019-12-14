package set1000.set1200.set1210.p1219

object Solution {
  val dd = Array(-1, 0, 1, 0, -1)

  def getMaximumGold(grid: Array[Array[Int]]): Int = {
    val n = grid.length
    val m = grid(0).length
    val vis = Array.ofDim[Boolean](n, m)

    def dfs(x: Int, y: Int): Int = {
      var best = 0
      var i = 0
      while (i < 4) {
        val u = x + dd(i)
        val v = y + dd(i + 1)
        if (u >= 0 && u < n && v >= 0 && v < m && grid(u)(v) > 0 && !vis(u)(v)) {
          vis(u)(v) = true
          best = best max (dfs(u, v))
          vis(u)(v) = false
        }
        i += 1
      }
      best + grid(x)(y)
    }

    var ans = 0
    for {
      x <- 0 until n
      y <- 0 until m
      if grid(x)(y) > 0
    } {
      vis(x)(y) = true
      ans = ans max dfs(x, y)
      vis(x)(y) = false
    }
    ans
  }
}
