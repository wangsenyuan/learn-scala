package set0000.set900.set940.p940

object Solution {
  val MOD = 1000000007

  def distinctSubseqII(S: String): Int = {
    val n = S.length
    val dp = Array.ofDim[Long](26)
    var sum = 0L

    var i = 0
    while (i < n) {
      val x = S(i) - 'a'
      //      val s = dp.sum % MOD
      val prev = dp(x)
      dp(x) = sum + 1
      sum = modAdd(sum, modSub(dp(x), prev))
      i += 1
    }

    (sum).toInt
  }

  private def modSub(a: Long, b: Long): Long = {
    val c = a - b
    if (c < 0) {
      c + MOD
    } else {
      c
    }
  }

  private def modAdd(a: Long, b: Long): Long = {
    val c = a + b
    if (c >= MOD) {
      c - MOD
    } else {
      c
    }
  }

  private def pow(a: Int, b: Int): Int = {
    var r = 1L
    var x = a.toLong
    var y = b
    while (y > 0) {
      if ((y & 1) == 1) {
        r *= x
        r %= MOD
      }
      x *= x
      x %= MOD
      y >>= 1
    }
    r.toInt
  }
}
