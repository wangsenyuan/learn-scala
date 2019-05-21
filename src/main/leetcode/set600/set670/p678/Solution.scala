package set600.set670.p678

object Solution {

  def checkValidString(s: String): Boolean = {
    var lo = 0
    var hi = 0
    var i = 0
    while(i < s.length) {
      if(s(i) == '(') {
        lo += 1
      } else {
        lo -= 1
      }

      if(s(i) != ')') {
        hi += 1
      } else {
        hi -= 1
      }

      if(hi < 0) {
        return false
      }

      lo = 0 max lo

      i += 1
    }

    lo == 0
  }

  def checkValidString1(s: String): Boolean = {
    val n = s.length
    if (n == 0) {
      true
    } else {
      val dp = Array.ofDim[Boolean](n, n)
      var j = 0
      while (j < n) {
        var i = j

        while (i >= 0) {
          if (i == j) {
            dp(i)(j) = s(i) == '*'
          } else if (i + 1 == j) {
            if (s(i) == '(' || s(i) == '*') {
              dp(i)(j) = s(j) == ')' || s(j) == '*'
            }
          } else {
            // i < j
            if (s(i) == '*') {
              dp(i)(j) = dp(i + 1)(j)
            }
            if (!dp(i)(j) && s(i) != ')') {
              if (s(j) == ')' || s(j) == '*') {
                dp(i)(j) = dp(i + 1)(j - 1)
              }
              var k = i + 1
              while (k <= j && !dp(i)(j)) {
                dp(i)(j) = dp(i)(k - 1) && dp(k)(j)
                k += 1
              }
            }
          }

          i -= 1
        }

        j += 1
      }

      dp(0)(n - 1)
    }
  }
}
