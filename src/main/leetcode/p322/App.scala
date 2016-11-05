package p322

/**
  * Created by wangsenyuan on 05/11/2016.
  */
object App {

  def main(args: Array[String]): Unit = {
    val coins = Array(186, 419, 83, 408)
    println(coinChange(coins, 6249))
  }

  def coinChange(coins: Array[Int], amount: Int): Int = {
    var total = Int.MaxValue;
    val sorted = coins.sorted
    def count(i: Int, amount: Int, cnt: Int): Unit = {
      if (i >= 0 && cnt < total) {
        val coin = sorted(i)
        var j = amount / coin
        while (j >= 0 && cnt + j < total) {
          val left = amount - j * coin
          if (left > 0 && cnt + j < total) {
            count(i - 1, left, cnt + j)
          } else if (cnt + j < total) {
            total = cnt + j
          }
          j -= 1
        }
      }
    }

    count(sorted.length - 1, amount, 0)

    total
  }
}
