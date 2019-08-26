package set0000.set700.set730.p730

object Solution {
  val MOD = 1000000007

  def countPalindromicSubsequences(S: String): Int = {
    val n = S.length
    val dp = Array.ofDim[Long](n, n)

    (0 until n).foreach(x => dp(x)(x) = 1)

    var j = 0
    while (j < n) {
      var i = j - 1
      while (i >= 0) {
        if (S(i) != S(j)) {
          dp(i)(j) = dp(i)(j - 1) + dp(i + 1)(j) - dp(i + 1)(j - 1)
        } else {
          var low = i + 1
          var high = j - 1
          while (low <= high && S(low) != S(j)) {
            low += 1
          }
          while (low <= high && S(high) != S(j)) {
            high -= 1
          }
          if (low > high) {
            dp(i)(j) = dp(i + 1)(j - 1) * 2 + 2
          } else if (low == high) {
            dp(i)(j) = dp(i + 1)(j - 1) * 2 + 1
          } else {
            dp(i)(j) = dp(i + 1)(j - 1) * 2 - dp(low + 1)(high - 1)
          }
        }
        if(dp(i)(j) < 0) {
          dp(i)(j) += MOD
        }
        dp(i)(j) %= MOD
        i -= 1
      }

      j += 1
    }

    dp(0)(n - 1).toInt
  }
}
