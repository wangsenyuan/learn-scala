package set0000.set600.set630.p639

object Solution {
  val MOD = 1000000007

  def numDecodings(s: String): Int = {
    val n = s.length
    val dp = Array.ofDim[Int](n + 1)
    dp(0) = 1
    if (s(0) == '*') {
      dp(1) = 9
    } else if (s(0) == '0') {
      return 0
    } else {
      dp(1) = 1
    }

    var i = 1
    while (i < n) {
      val a = s(i - 1)
      val b = s(i)
      if (b == '*') {
        dp(i + 1) = modMul(9, dp(i))
        if (a == '*') {
          dp(i + 1) = modAdd(dp(i + 1), modMul(15, dp(i - 1)))
        } else if (a == '1') {
          dp(i + 1) = modAdd(dp(i + 1), modMul(9, dp(i - 1)))
        } else if (a == '2') {
          dp(i + 1) = modAdd(dp(i + 1), modMul(6, dp(i - 1)))
        }
      } else if (b == '0') {
        if (a == '*') {
          dp(i + 1) = modAdd(0, 2 * dp(i - 1))
        } else if (a == '1' || a == '2') {
          dp(i + 1) = dp(i - 1)
        } else {
          // 30, can't be true
          return 0
        }
      } else {
        dp(i + 1) = dp(i)
        if (a == '*') {
          // fix a as 1
          dp(i + 1) = modAdd(dp(i + 1), dp(i - 1))
          if (b < '7') {
            // fix a as 2
            dp(i + 1) = modAdd(dp(i + 1), dp(i - 1))
          }
        } else if (a == '1' || (a == '2' && b < '7')) {
          dp(i + 1) = modAdd(dp(i + 1), dp(i - 1))
        }

      }

      i += 1
    }


    dp(n)
  }

  private def modAdd(a: Int, b: Int): Int = {
    (a + b) % MOD
  }

  private def modMul(a: Int, b: Int): Int = {
    val x = a.toLong
    val y = b.toLong
    ((x * y) % MOD).toInt
  }
}
