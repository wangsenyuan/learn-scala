package set0000.set700.set710.p712

object Solution {
  def minimumDeleteSum(s1: String, s2: String): Int = {
    val m = s1.length
    val n = s2.length
    val dp = Array.fill(m + 1, n + 1)(Int.MaxValue)
    dp(0)(0) = 0

    var i = 0

    while(i < n) {
      dp(0)(i+1) = dp(0)(i) + s2(i)
      i += 1
    }

    i = 0
    while(i < m) {
      dp(i+1)(0) = dp(i)(0) + s1(i)
      i += 1
    }

    i = 0
    while(i < m) {
      var j = 0
      while(j < n) {
        if(s1(i) == s2(j)) {
          dp(i+1)(j+1) = dp(i)(j)
        } else {
          dp(i+1)(j+1) = (dp(i)(j+1) + s1(i)) min (dp(i+1)(j) + s2(j))
        }

        j += 1
      }

      i += 1
    }

    dp(m)(n)
  }
}
