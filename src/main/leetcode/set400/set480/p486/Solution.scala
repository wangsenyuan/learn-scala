package set400.set480.p486

object Solution {
  def PredictTheWinner(nums: Array[Int]): Boolean = {
    val n = nums.length
    val sum = calSum(nums, n)

    val dp = Array.fill(n, n)(Int.MinValue)

    for {
      k <- 1 to n
      i <- 0 until n
      j = i + k - 1
      if(j < n)
    } {
      if (k == 1) {
        dp(i)(j) = sum(i)(j)
      } else {
        dp(i)(j) = (sum(i)(j) - dp(i + 1)(j)) max (sum(i)(j) - dp(i)(j - 1))
      }
    }

    dp(0)(n - 1) * 2 >= sum(0)(n - 1)
  }

  def PredictTheWinner1(nums: Array[Int]): Boolean = {
    val n = nums.length
    val sum = calSum(nums, n)

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


  private def calSum(nums: Array[Int], n: Int) = {
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
    sum
  }
}
