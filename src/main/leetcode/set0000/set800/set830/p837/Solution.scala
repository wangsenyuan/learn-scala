package set0000.set800.set830.p837

object Solution {
  def new21Game(N: Int, K: Int, W: Int): Double = {
    val dp = Array.ofDim[Double](N + W + 1)
    for {
      k <- K to N
    } {
      dp(k) = 1.0
    }

    var s = ((N - K + 1) min W).toDouble

    for {
      k <- (K - 1) to 0 by -1
    } {
      dp(k) = s / W
      s += dp(k) - dp(k + W)
    }

    dp(0)
  }
}
