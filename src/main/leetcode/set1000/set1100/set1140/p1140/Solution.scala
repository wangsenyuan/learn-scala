package set1000.set1100.set1140.p1140

object Solution {
  def stoneGameII(piles: Array[Int]): Int = {
    val n = piles.length
    val dp = Array.fill(n, n + 1)(-1)

    val sum = Array.ofDim[Int](n + 1)

    for {
      i <- 0 until n
    } {
      sum(i + 1) = sum(i) + piles(i)
    }


    def dfs(i: Int, m: Int): Int = {
      if (i >= n) {
        0
      } else if (dp(i)(m) >= 0) {
        dp(i)(m)
      } else {
        val all = sum(n) - sum(i)
        var best = 0
        for {
          x <- 1 to 2 * m
          if i + x <= n
        } {
          val z = dfs(i + x, x max m)
          val tmp = all - z
          best = best max tmp
        }
        dp(i)(m) = best
        best
      }
    }

    dfs(0, 1)
  }
}
