package set000.set090.p097

object Solution {
  def isInterleave(s1: String, s2: String, s3: String): Boolean = {
    if (s1.length + s2.length != s3.length) {
      false
    } else {
      val m = s1.length
      val n = s2.length
      val dp = Array.fill(m + 1, n + 1)(false)
      dp(0)(0) = true

      var i = 0
      while (i < m && s1(i) == s3(i)) {
        dp(i + 1)(0) = true
        i += 1
      }
      var j = 0
      while (j < n && s2(j) == s3(j)) {
        dp(0)(j + 1) = true
        j += 1
      }

      i = 1

      while (i <= m) {
        j = 1
        while (j <= n) {
          val k = i + j
          if (s1(i - 1) == s3(k - 1)) {
            dp(i)(j) = dp(i)(j) || dp(i - 1)(j)
          }
          if (s2(j - 1) == s3(k - 1)) {
            dp(i)(j) = dp(i)(j) || dp(i)(j - 1)
          }
          j += 1
        }
        i += 1
      }


      dp(m)(n)
    }
  }
}
