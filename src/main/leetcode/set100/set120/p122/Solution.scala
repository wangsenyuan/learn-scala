package set100.set120.p122

object Solution {
  def maxProfit(prices: Array[Int]): Int = {
    if (prices.size < 2) {
      0
    } else {
      val pp = prices.zip(prices.tail)
      val ss = pp.map(x => 0 max (x._2 - x._1))
      ss.sum
    }
  }

  def maxProfit1(prices: Array[Int]): Int = {
    val n = prices.length
    val dp = Array.fill(n + 1)(0)
    var i = 0
    while (i < n) {
      dp(i + 1) = dp(i)
      var j = 0
      while (j < i) {
        dp(i + 1) = dp(i + 1) max (dp(j) + prices(i) - prices(j))
        j += 1
      }
      i += 1
    }

    dp(n)
  }
}
