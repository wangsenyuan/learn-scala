package set300.set300.p309

object Solution {
  def maxProfit(prices: Array[Int]): Int = {
    val n = prices.length
    if (n < 2) {
      0
    } else {
      val buy = Array.fill(n)(Int.MinValue)
      val sell = Array.fill(n)(Int.MinValue)

      buy(0) = -prices(0)
      buy(1) = (-prices(0)) max (-prices(1))

      sell(0) = 0
      sell(1) = 0 max (prices(1) - prices(0))
      var i = 2
      while (i < n) {
        sell(i) = sell(i - 1) max (buy(i - 1) + prices(i))

        buy(i) = buy(i - 1) max (sell(i - 2) - prices(i))

        i += 1
      }
      buy(n - 1) max sell(n - 1)
    }
  }
}
