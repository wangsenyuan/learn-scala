package set100.set120.p123

object Solution {
  def maxProfit(prices: Array[Int]): Int = {
    var firstBuy = Int.MinValue
    var firstSell = 0
    var secondBuy = Int.MinValue
    var secondSell = 0

    var i = 0
    while (i < prices.length) {
      firstBuy = firstBuy max -prices(i)

      firstSell = firstSell max (firstBuy + prices(i))

      secondBuy = secondBuy max (firstSell - prices(i))

      secondSell = secondSell max (secondBuy + prices(i))

      i += 1
    }

    secondSell
  }
}
