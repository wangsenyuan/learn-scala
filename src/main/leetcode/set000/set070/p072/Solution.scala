package set000.set070.p072

object Solution {

  def minDistance(word1: String, word2: String): Int = {
    val m = word1.length
    val n = word2.length
    if (m == 0) {
      n
    } else if (n == 0) {
      m
    } else {
      val dp = Array.fill(2, n + 1)(m max n)

      dp(0)(0) = 0

      var i = 1
      while (i <= n) {
        dp(0)(i) = i
        i += 1
      }
      var p = 0

      i = 1
      while (i <= m) {
        val q = 1 - p

        dp(q)(0) = i

        var j = 1
        while (j <= n) {
          dp(q)(j) = dp(p)(j - 1) min dp(p)(j) min dp(q)(j - 1)
          dp(q)(j) += 1
          if (word1(i - 1) == word2(j - 1)) {
            dp(q)(j) = dp(q)(j) min dp(p)(j - 1)
          }
          j += 1
        }
        p = q
        i += 1
      }


      dp(p)(n)
    }
  }
}
