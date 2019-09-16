package set0000.set900.set930.p935

object Solution {
  val MOD = 1000000007

  def knightDialer(N: Int): Int = {
    val dp = Array.ofDim[Long](10)
    val fp = Array.ofDim[Long](10)

    (0 until 10).foreach(i => dp(i) = 1)

    var i = 1
    while (i < N) {
      fp(0) = modAdd(dp(4), dp(6))
      fp(1) = modAdd(dp(6), dp(8))
      fp(2) = modAdd(dp(7), dp(9))
      fp(3) = modAdd(dp(4), dp(8))
      fp(4) = modAdd(modAdd(dp(3), dp(9)), dp(0))
      fp(5) = 0
      fp(6) = modAdd(modAdd(dp(1), dp(7)), dp(0))
      fp(7) = modAdd(dp(2), dp(6))
      fp(8) = modAdd(dp(1), dp(3))
      fp(9) = modAdd(dp(2), dp(4))

      (0 until 10).foreach(j => dp(j) = fp(j))
      i += 1
    }

    val r = dp.sum

    (r % MOD).toInt
  }

  private def modAdd(a: Long, b: Long): Long = {
    val c = a + b
    if (c >= MOD) {
      c - MOD
    } else {
      c
    }
  }
}
