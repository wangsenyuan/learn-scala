package set500.set570.p576

object Solution {
  val MOD = 1000000007

  def findPaths(m: Int, n: Int, N: Int, i: Int, j: Int): Int = {
    val dd = Array(-1, 0, 1, 0, -1)
    val dp = Array.ofDim[Long](m + 2, n + 2, N + 1)
    dp(i + 1)(j + 1)(0) = 1

    for {
      p <- 1 to N
      x <- 1 to m
      y <- 1 to n
      k <- 0 until 4
      u = x + dd(k)
      v = y + dd(k + 1)
    } {
      dp(u)(v)(p) = modAdd(dp(u)(v)(p), dp(x)(y)(p - 1))
    }

    var res = 0L

    for {
      k <- 1 to m
      p <- 1 to N
    } {
      res = modAdd(res, dp(k)(0)(p))
      res = modAdd(res, dp(k)(n + 1)(p))
    }

    for {
      k <- 1 to n
      p <- 1 to N
    } {
      res = modAdd(res, dp(0)(k)(p))
      res = modAdd(res, dp(m+1)(k)(p))
    }

    res.toInt
  }

  private def modAdd(a: Long, b: Long): Long = {
    val c = a + b
    if (c >= MOD) {
      c - MOD
    } else {
      c
    }
  }
}
