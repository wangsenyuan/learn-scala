package set100.set130.p132

object Solution {
  def minCut(s: String): Int = {
    val n = s.length
    val pal = Array.fill(n, n)(false)
    for {
      i <- 0 until n
    } {
      pal(i)(i) = true
      if (i + 1 < n && s(i) == s(i + 1)) {
        pal(i)(i + 1) = true
      }
    }

    for {
      k <- 3 to n
      i <- 0 until n
      j = i + k - 1
      if j < n
    } {
      pal(i)(j) = s(i) == s(j) && pal(i + 1)(j - 1)
    }

    val dp = Array.fill(n, n)(Int.MaxValue >> 1)

    for {
      k <- 1 to n
      i <- 0 until n
      j = i + k - 1
      if j < n
    } {
      if (pal(i)(j)) {
        dp(i)(j) = 0
      } else {
        var ans = Int.MaxValue >> 1
        for {
          l <- 1 until k
        } {
          ans = ans min (1 + dp(i)(i + l - 1) + dp(i + l)(j))
        }
        dp(i)(j) = ans
      }
    }

    dp(0)(n - 1)
  }
}
