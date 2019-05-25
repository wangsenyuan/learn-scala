package set600.set690.p695

object Solution {
  val dd = Array(-1, 0, 1, 0, -1)

  def maxAreaOfIsland(grid: Array[Array[Int]]): Int = {
    if (grid.length == 0 || grid(0).length == 0) {
      0
    } else {
      val m = grid.length
      val n = grid(0).length
      val vis = Array.ofDim[Boolean](m, n)

      def dfs(u: Int, v: Int): Int = {
        vis(u)(v) = true
        var res = 1
        var k = 0
        while (k < 4) {
          val x = u + dd(k)
          val y = v + dd(k + 1)
          if (x >= 0 && x < m && y >= 0 && y < n && grid(x)(y) == 1 && !vis(x)(y)) {
            res += dfs(x, y)
          }
          k += 1
        }

        res
      }

      var best = 0
      var i = 0
      while (i < m) {
        var j = 0
        while (j < n) {
          if (grid(i)(j) == 1 && !vis(i)(j)) {
            best = best max dfs(i, j)
          }

          j += 1
        }

        i += 1
      }

      best
    }
  }
}
