package set1000.set1200.set1260.p1269

object Solution {
  val MOD = 1000000007

  private def modAdd(a: Int, b: Int): Int = {
    val c = a + b
    if (c >= MOD) {
      c - MOD
    } else {
      c
    }
  }

  def numWays(steps: Int, arrLen: Int): Int = {
    val n = (steps / 2 + 3) min arrLen
    val dp = Array.ofDim[Int](n)
    dp(0) = 1

    val fp = Array.ofDim[Int](n)

    var i = 0
    while (i < steps) {
      var j = 0
      while (j < n) {
        fp(j) = dp(j)
        if (j > 0) {
          fp(j) = modAdd(fp(j), dp(j - 1))
        }
        if (j < n - 1) {
          fp(j) = modAdd(fp(j), dp(j + 1))
        }
        j += 1
      }

      j = 0
      while (j < n) {
        dp(j) = fp(j)
        fp(j) = 0
        j += 1
      }

      i += 1
    }

    dp(0)
  }
}
