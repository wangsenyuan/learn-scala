package set1000.set1000.set1040.p1049

object Solution {
  def lastStoneWeightII(stones: Array[Int]): Int = {
    val n = stones.length
    val N = 100 * n
    val dp = Array.ofDim[Boolean](N + 1)
    dp(0) = true

    val fp = Array.ofDim[Boolean](N + 1)

    var i = 0
    while(i < n) {
      for {
        x <- 0 to N
      } {
        fp(x) = dp(x)
        dp(x) = false
      }

      for {
        x <- 0 to N
        if fp(x)
      } {
        dp(x + stones(i)) = true
        if(x >= stones(i)) {
          dp(x - stones(i)) = true
        } else {
          dp(stones(i) - x) = true
        }
      }

      i += 1
    }

    (0 to N).dropWhile(!dp(_)).head

  }
}
