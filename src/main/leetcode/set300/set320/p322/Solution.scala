package set300.set320.p322

object Solution {
  def coinChange(coins: Array[Int], amount: Int): Int = {
    //    val cs = coins.filter(_ <= amount).sorted
    val n = coins.length

    val INF = 1 << 20
    val dp = Array.fill(amount + 1)(INF)

    dp(0) = 0

    for {
      x <- 1 to amount
      i <- 0 until n
      if x >= coins(i)
    } {
      dp(x) = dp(x) min (1 + dp(x - coins(i)))
    }

    val res = dp(amount)
    if (res >= INF) {
      -1
    } else {
      res
    }
  }

  def coinChange1(coins: Array[Int], amount: Int): Int = {
    val cs = coins.filter(_ <= amount).sorted
    val n = cs.length

    val INF = 1 << 20

    var best = INF

    // a0 * c0 + a1 * c1 + a2 * c2 + ... + an-1 * cn-1 = amount
    // a0 + a1 + a2 + .... + an-1 minmium
    def dfs(i: Int, cnt: Int, amount: Int): Unit = {
      if (amount == 0) {
        best = best min cnt
      } else if (cnt < best && amount > 0 && i >= 0) {
        var j = i
        while (j >= 0) {
          dfs(j, cnt + 1, amount - cs(j))
          j -= 1
        }
      }
    }

    dfs(n - 1, 0, amount)

    if (best == INF) {
      -1
    } else {
      best
    }
  }
}
