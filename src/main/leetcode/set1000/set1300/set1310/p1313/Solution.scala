package set1000.set1300.set1310.p1313

object Solution {
  def minInsertions(s: String): Int = {
    val n = s.length

    val dp = Array.ofDim[Int](n, n)

    for {
      j <- 0 until n
      i <- (j - 1) to 0 by -1
    } {
      if (s(i) == s(j)) {
        dp(i)(j) = dp(i + 1)(j - 1)
      } else {
        dp(i)(j) = (dp(i + 1)(j) min dp(i)(j - 1)) + 1
      }
    }
    dp(0)(n - 1)
  }
}
