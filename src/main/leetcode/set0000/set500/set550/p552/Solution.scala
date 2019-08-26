package set0000.set500.set550.p552

object Solution {
  val MOD = 1000000007

  def checkRecord(n: Int): Int = {
    if (n == 0) {
      1
    } else if (n == 1) {
      3
    } else if (n == 2) {
      8
    } else {
      val dp = Array.ofDim[Long](n + 1)
      dp(0) = 1
      dp(1) = 2 // P/L
      dp(2) = 4 // PP/LP/PL/LL

      for {
        i <- 3 to n
      } {
        dp(i) = (dp(i - 1) + dp(i - 2) + dp(i - 3)) % MOD
      }

      var ans = dp(n)

      for {
        i <- 0 until n
      } {
        val left = dp(i)
        val right = dp(n - 1 - i)
        val tmp = (left * right) % MOD
        ans += tmp
        if (ans >= MOD) {
          ans -= MOD
        }
      }

      ans.toInt
    }
  }


}
