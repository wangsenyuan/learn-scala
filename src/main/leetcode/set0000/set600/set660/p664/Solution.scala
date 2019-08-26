package set0000.set600.set660.p664

object Solution {
  def strangePrinter(s: String): Int = {
    val n = s.length

    if(n == 0) {
      0
    } else {
      val dp = Array.fill(n, n)(Int.MaxValue)

      var j = 0
      while (j < n) {
        var i = j
        while (i >= 0) {
          // cal dp(i)(j)
          if (i == j) {
            dp(i)(j) = 1
          } else {
            if (s(i) == s(i + 1)) {
              dp(i)(j) = dp(i)(j) min (dp(i + 1)(j))
            } else {
              dp(i)(j) = dp(i+1)(j) + 1
              var k = i + 1
              while(k <= j) {
                if(s(i) == s(k)) {
                  dp(i)(j) = dp(i)(j) min (dp(i+1)(k-1) + dp(k)(j))
                }
                k +=1
              }
            }

          }

          i -= 1
        }

        j += 1
      }

      dp(0)(n-1)
    }
  }
}
