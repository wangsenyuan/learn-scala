package set0000.set600.set620.p629

object Solution {
  val MOD = 1000000007

  def kInversePairs(n: Int, k: Int): Int = {
    val dp = Array.ofDim[Int](n + 1, k + 1)
    dp(0)(0) = 1
    for {
      i <- 1 to n
    } {
      var sum = 0
      for {
        j <- 0 to k
      } {
        if (j == 0) {
          dp(i)(j) = 1
          sum += 1
        } else {
          sum = modAdd(sum, dp(i - 1)(j))
          if (j - i >= 0) {
            sum = modSub(sum, dp(i - 1)(j - i))
          }
          dp(i)(j) = sum
        }
      }
    }

    dp(n)(k)
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
