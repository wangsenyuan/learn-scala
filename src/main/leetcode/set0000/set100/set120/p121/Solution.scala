package set0000.set100.set120.p121

object Solution {
  def maxProfit(prices: Array[Int]): Int = {
    if (prices.size <= 1) {
      0
    } else {
      var buy = Int.MaxValue >> 1
      var sell = 0
      var i = 0
      while (i < prices.length) {
        sell = sell max (prices(i) - buy)
        buy = buy min prices(i)
        i += 1
      }
      sell
    }
  }
}
