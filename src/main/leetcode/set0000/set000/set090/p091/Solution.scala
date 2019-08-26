package set0000.set000.set090.p091

object Solution {
  def numDecodings(s: String): Int = {
    val n = s.length
    val dp = Array.fill(n + 1)(0)
    dp(0) = 1
    var i = 1
    while (i <= n) {
      val x = s(i - 1) - '0'
      if (x > 0) {
        dp(i) += dp(i - 1)
      }
      if (i > 1) {
        val y = (s(i - 2) - '0')
        if (y > 0 && y * 10 + x <= 26) {
          dp(i) += dp(i - 2)
        }
      }
      i += 1
    }

    dp(n)
  }
}
