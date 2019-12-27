package set1000.set1200.set1270.p1278

object Solution {
  val INF = 1 << 30

  def palindromePartition(s: String, k: Int): Int = {
    val n = s.length

    val fp = Array.ofDim[Int](n, n)

    for {
      j <- 1 until n
      i <- (j - 1) to 0 by -1
    } {
      if (s(i) == s(j)) {
        fp(i)(j) = fp(i + 1)(j - 1)
      } else {
        fp(i)(j) = fp(i + 1)(j - 1) + 1
      }
    }

    val dp = Array.fill[Int](n + 1, k + 1)(INF)
    dp(0)(0) = 0

    var i = 0
    while (i < n) {

      var kk = 0
      while (kk < k && kk <= i) {
        var j = 0
        while (j <= i) {
          if (dp(j)(kk) < INF) {
            dp(i + 1)(kk + 1) = dp(i + 1)(kk + 1) min (dp(j)(kk) + fp(j)(i))
          }
          j += 1
        }

        kk += 1
      }

      i += 1
    }

    dp(n)(k)
  }
}
