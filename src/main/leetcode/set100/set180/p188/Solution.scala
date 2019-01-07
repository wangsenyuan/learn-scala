package set100.set180.p188

object Solution {

  def maxProfit(k: Int, prices: Array[Int]): Int = {
    val n = prices.length

    if (n == 0) {
      0
    } else if (k > n / 2) {
      val xx = prices.tail.zip(prices)
      val x = xx.map(x => 0 max (x._1 - x._2))
      x.sum
    } else {
      val dp = Array.fill(n + 1)(0)

      for {
        j <- 1 to k
      } {
        for {
          i <- (n - 1) to 0 by -1
          u <- 0 until i
        } {
          dp(i) = dp(i) max (dp(u) + prices(i) - prices(u))
        }

        for {
          i <- 1 to n
        } {
          dp(i) = dp(i) max dp(i - 1)
        }
      }

      dp(n)
    }
  }
}
