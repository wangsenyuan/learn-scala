package set000.set040.p044

object Solution {
  def isMatch(s: String, p: String): Boolean = {
    val m = s.length
    val n = p.length
    val dp = Array.fill(m + 1, n + 1)(false)
    dp(0)(0) = true

    var k = 0
    while (k < n && p(k) == '*') {
      dp(0)(k + 1) = true
      k += 1
    }
    for {
      i <- 0 until m
      j <- 0 until n
    } {
      //try to compute dp(i+1)(j+1) from prev state
      if (p(j) == '?' || s(i) == p(j)) {
        // match
        dp(i + 1)(j + 1) = dp(i)(j)
      } else if (p(j) == '*') {
        dp(i + 1)(j + 1) = dp(i + 1)(j) || dp(i)(j) || dp(i)(j + 1)
      }
    }


    dp(m)(n)
  }

  def isMatch1(s: String, p: String): Boolean = {
    def go(i: Int, j: Int): Boolean = {
      if (j == p.length) {
        i == s.length
      } else if (i == s.length) {
        if (p(j) == '*') {
          go(i, j + 1)
        } else {
          false
        }
      } else if (p(j) == '*') {
        go(i, j + 1) || go(i + 1, j) || go(i + 1, j + 1)
      } else if (p(j) == '?' || s(i) == p(j)) {
        go(i + 1, j + 1)
      } else {
        false
      }
    }

    go(0, 0)
  }
}
