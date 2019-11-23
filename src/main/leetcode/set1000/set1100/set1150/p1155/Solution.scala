package set1000.set1100.set1150.p1155

object Solution {
  val MOD = 1000000007

  def numRollsToTarget(d: Int, f: Int, target: Int): Int = {
    val dp = Array.ofDim[Int](target + 1)
    dp(0) = 1
    val fp = Array.ofDim[Int](target + 1 + f)

    for {
      _ <- 0 until d
    } {
      fp(0) = 0
      for {
        x <- 0 until target
      } {
        fp(x + 1) = modAdd(fp(x + 1), dp(x))
        fp(x + f + 1) = modSub(fp(x + f + 1), dp(x))
      }

      for {
        x <- 1 to target
      } {
        fp(x) = modAdd(fp(x), fp(x - 1))
      }

      for {
        x <- 0 to target
      } {
        dp(x) = fp(x)
        fp(x) = 0
      }
    }
    dp(target)
  }

  def numRollsToTarget1(d: Int, f: Int, target: Int): Int = {
    val dp = Array.ofDim[Int](target + 1)
    dp(0) = 1
    val fp = Array.ofDim[Int](target + 1)
    for {
      x <- 0 until d
    } {
      for {
        i <- 0 to target
      } {
        fp(i) = dp(i)
        dp(i) = 0
      }

      for {
        i <- x to target
        j <- 1 to f
        if i + j <= target
      } {
        dp(i + j) = modAdd(dp(i + j), fp(i))
      }
    }

    dp(target)
  }

  private def modAdd(a: Int, b: Int): Int = {
    val c = a + b
    if (c >= MOD) {
      c - MOD
    } else {
      c
    }
  }

  private def modSub(a: Int, b: Int): Int = {
    val c = a - b
    if (c < 0) {
      c + MOD
    } else {
      c
    }
  }
}
