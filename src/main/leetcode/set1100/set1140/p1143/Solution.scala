package set1100.set1140.p1143

object Solution {
  def longestCommonSubsequence(text1: String, text2: String): Int = {
    val m = text1.length
    val n = text2.length
    val dp = Array.ofDim[Int](m + 1, n + 1)
    for {
      i <- 0 until m
      j <- 0 until n
    } {
      if (text1(i) == text2(j)) {
        dp(i + 1)(j + 1) = dp(i)(j) + 1
      } else {
        dp(i + 1)(j + 1) = dp(i)(j + 1) max dp(i + 1)(j)
      }
    }

    dp(m)(n)
  }
}
