package set100.set110.p115

object Solution {

  def numDistinct(s: String, t: String): Int = {
    val m = s.length
    val n = t.length
    if (m < n) {
      0
    } else {
      val dp = Array.fill(m + 1, n + 1)(0)
      dp(0)(0) = 1

      for {
        k <- 1 to m
      } {
        dp(k)(0) = 1
      }

      var j = 1
      while (j <= n) {
        var i = j
        while (i <= m) {
          //choose j from s[..i] should contain s[..i-1]
          dp(i)(j) = dp(i - 1)(j)

          if (s(i - 1) == t(j - 1)) {
            dp(i)(j) += dp(i - 1)(j - 1)
          }

          i += 1
        }

        j += 1
      }

      dp(m)(n)
    }
  }
}
