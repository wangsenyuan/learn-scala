package set0000.set900.set920.p926

object Solution {
  def minFlipsMonoIncr(S: String): Int = {
    val n = S.length
    val dp = Array.ofDim[Int](n)
    var i = 0
    while (i < n) {
      if (S(i) == '1') {
        dp(i) = 1
      }
      if (i > 0) {
        dp(i) += dp(i - 1)
      }
      i += 1
    }

    val fp = Array.ofDim[Int](n)
    i = n - 1
    while (i >= 0) {
      if (S(i) == '0') {
        fp(i) = 1
      }
      if (i < n - 1) {
        fp(i) += fp(i + 1)
      }
      i -= 1
    }
    // dp(n - 1) + fp(0) == n
    var ans = dp(n - 1) min fp(0)

    i = 0
    while (i < n - 1) {
      // flip all ones before i (including) to 0
      ans = ans min (dp(i) + fp(i + 1))

      i += 1
    }

    ans
  }
}
