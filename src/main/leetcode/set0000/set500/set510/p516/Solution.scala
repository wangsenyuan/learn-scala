package set0000.set500.set510.p516

object Solution {
  def longestPalindromeSubseq(s: String): Int = {
    val n = s.length
    if (n <= 1) {
      n
    } else {
      // dp(i, j) = s(i) == s(j) ? dp(i+1, j - 1) + 2
      val dp = Array.fill(n, n)(0)

      for {
        i <- 0 until n
      } {
        dp(i)(i) = 1
      }

      for {
        k <- 2 to n
        i <- 0 until n
        j = i + k - 1
        if(j < n)
      } {
        if (s(i) == s(j)) {
          dp(i)(j) = 2 + dp(i + 1)(j - 1)
        } else {
          dp(i)(j) = dp(i + 1)(j) max dp(i)(j - 1)
        }
      }

      dp(0)(n - 1)
    }
  }
}
