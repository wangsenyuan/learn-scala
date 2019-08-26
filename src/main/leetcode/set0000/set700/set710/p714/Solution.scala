package set0000.set700.set710.p714

object Solution {
  def maxProfit(prices: Array[Int], fee: Int): Int = {
    var sell = 0
    var buy = Int.MinValue >> 1

    var i = 0
    while(i < prices.length) {
      val cur = prices(i)

      buy = buy max (sell - cur)
      sell = sell max (buy + cur - fee)

      i += 1
    }

    buy max sell
  }
}
