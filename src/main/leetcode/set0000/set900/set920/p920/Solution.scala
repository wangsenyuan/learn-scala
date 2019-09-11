package set0000.set900.set920.p920

object Solution {

  val MOD = 1000000007

  def numMusicPlaylists(N: Int, L: Int, K: Int): Int = {
    val dp = Array.ofDim[Long](L + 1, N + 1)
    dp(0)(0) = 1

    // dp(i)(j) = dp(i-1) + dp(j-1)
    //           + dp(i)(j-1 - K) * (i - K)

    for {
      i <- 1 to L
      j <- 1 to N
    } {
      dp(i)(j) += dp(i - 1)(j - 1) * (N - j + 1)
      dp(i)(j) += dp(i - 1)(j) * (0 max (j - K))
      dp(i)(j) %= MOD
    }

    dp(L)(N).toInt
  }
}
