package set0000.set300.set320.p329

object Solution {
  val dd = Array(-1, 0, 1, 0, -1)

  def longestIncreasingPath(matrix: Array[Array[Int]]): Int = {
    val m = matrix.length
    if (m == 0) {
      0
    } else {
      val n = matrix(0).length
      if (n == 0) {
        0
      } else {
        val dp = Array.fill(m, n)(-1)

        def dfs(x: Int, y: Int): Int = {
          if (dp(x)(y) < 0) {
            var best = 0

            for {
              k <- 0 until 4
              u = x + dd(k)
              v = y + dd(k + 1)
              if u >= 0 && u < m && v >= 0 && v < n && matrix(u)(v) < matrix(x)(y)
            } {
              best = dfs(u, v) max best
            }

            dp(x)(y) = best + 1
          }

          dp(x)(y)
        }

        for {
          i <- 0 until m
          j <- 0 until n
        } {
          dp(i)(j) = dfs(i, j)
        }

        dp.foldLeft(0)((x, r) => r.foldLeft(x)(_ max _))
      }
    }
  }
}
