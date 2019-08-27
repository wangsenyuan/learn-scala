package set0000.set800.set870.p879

object Solution {
  val MOD = 1000000007

  def profitableSchemes(G: Int, P: Int, group: Array[Int], profit: Array[Int]): Int = {
    // dp[x][y] is the ways to use x members to get y profit
    //    val M = group.sum
    //    val N = profit.sum
    val dp = Array.ofDim[Int](G + 1, P + 1)
    val fp = Array.ofDim[Int](G + 1, P + 1)
    // fp[x][y] is the ways to use at most x members to get at least y profile

    //
    dp(0)(0) = 1

    val n = group.length
    var i = 0
    while (i < n) {
      val g = group(i)
      val p = profit(i)

      resetTo(fp, dp)

      for {
        x <- 0 to G - g
        y <- 0 to P
      } {
        val u = x + g
        val v = P min (y + p)
        fp(u)(v) += dp(x)(y)
        if (fp(u)(v) >= MOD) {
          fp(u)(v) -= MOD
        }
      }

      resetTo(dp, fp)

      i += 1
    }

    var res = 0

    for {
      x <- 1 to G
    } {
      res += dp(x)(P)
      if (res >= MOD) {
        res -= MOD
      }
    }

    res
  }

  private def resetTo(dst: Array[Array[Int]], src: Array[Array[Int]]): Unit = {
    for {
      i <- 0 until dst.length
      j <- 0 until dst(0).length
    } {
      dst(i)(j) = src(i)(j)
    }
  }
}
