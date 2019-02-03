package set300.set310.p312

object Solution {
  def maxCoins(nums: Array[Int]): Int = {
    val n = nums.length
    val dp = Array.ofDim[Int](n + 2, n + 2)

    for {
      k <- 1 to n
      i <- 0 until (n + 1 - k)
      j = i + k + 1
    } {
      val a = if (i == 0) {
        1
      } else {
        nums(i - 1)
      }
      val b = if (j == n + 1) {
        1
      } else {
        nums(j - 1)
      }

      for {
        p <- (i + 1) until j
      } {
        dp(i)(j) = dp(i)(j) max (dp(i)(p) + dp(p)(j) + a * nums(p - 1) * b)
      }
    }


    dp(0)(n + 1)
  }
}
