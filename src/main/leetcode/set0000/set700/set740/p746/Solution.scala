package set0000.set700.set740.p746

object Solution {
  def minCostClimbingStairs(cost: Array[Int]): Int = {
    val n = cost.length

    if(n <= 1) {
      0
    } else if(n == 2) {
      cost(0) min cost(1)
    } else {
      val dp = Array.fill(n)(Int.MaxValue)
      dp(0) = cost(0)
      dp(1) = cost(1)
      var i = 2
      while(i < n) {
        dp(i) = (dp(i-1) min dp(i-2)) + cost(i)
        i += 1
      }

      dp(n-1) min dp(n - 2)
    }
  }
}
