package set400.set480.p486

object Solution {
  def PredictTheWinner(nums: Array[Int]): Boolean = {
    val n = nums.length
    val sum = Array.ofDim[Int](n, n)

    for {
      i <- 0 until n
      j <- i until n
    } {
      if (i == j) {
        sum(i)(j) = nums(i)
      } else {
        sum(i)(j) = sum(i)(j - 1) + nums(j)
      }
    }

    // dp[i][j] = the best, first player can get
    val dp = Array.fill(n, n)(-1)

    def loop(i: Int, j: Int): Int = {
      if (dp(i)(j) < 0) {
        if (i == j) {
          dp(i)(j) = nums(i)
        } else {
          val s = sum(i)(j)
          val a = s - loop(i + 1, j)
          val b = s - loop(i, j - 1)
          dp(i)(j) = a max b
        }
      }
      dp(i)(j)
    }

    loop(0, n - 1) * 2 >= sum(0)(n - 1)
  }


}
