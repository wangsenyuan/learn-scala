package set0000.set900.set930.p931

object Solution {
  def minFallingPathSum(A: Array[Array[Int]]): Int = {
    val m = A.length
    val n = A(0).length
    val dp = Array.fill(m, n)(Int.MaxValue)
    (0 until n).foreach(j => dp(0)(j) = A(0)(j))

    for {
      i <- 1 until m
      j <- 0 until n
    } {
      dp(i)(j) = dp(i)(j) min (dp(i - 1)(j) + A(i)(j))
      if (j > 0) {
        dp(i)(j) = dp(i)(j) min (dp(i - 1)(j - 1) + A(i)(j))
      }
      if (j < n - 1) {
        dp(i)(j) = dp(i)(j) min (dp(i - 1)(j + 1) + A(i)(j))
      }
    }

    dp(m - 1) min
  }
}
