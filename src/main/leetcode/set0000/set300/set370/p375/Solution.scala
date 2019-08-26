package set0000.set300.set370.p375

object Solution {
  def getMoneyAmount(n: Int): Int = {
    if (n == 1) {
      0
    } else {
      val dp = Array.ofDim[Int](n + 1, n + 1)

      for {
        l <- 1 until n
        i <- 0 until n
        j = i + l
        if (j <= n)
      } {
        dp(i)(j) = Int.MaxValue
        for {
          k <- i to j
        } {
          val a = if (i == k) {
            0
          } else {
            dp(i)(k - 1)
          }

          val b = if (j == k) {
            0
          } else {
            dp(k + 1)(j)
          }

          dp(i)(j) = dp(i)(j) min ((a max b) + k)
        }
      }

      dp(1)(n)
    }
  }
}
