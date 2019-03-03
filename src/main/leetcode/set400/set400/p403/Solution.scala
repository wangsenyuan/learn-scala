package set400.set400.p403

object Solution {
  def canCross(stones: Array[Int]): Boolean = {
    val n = stones.size
    //dp[i][k] means stop at stone i, with take a k-jump
    val dp = Array.ofDim[Boolean](n, n)
    // 1 for true, -1 for false, 0 for not set
    dp(0)(0) = true

    def findNextPos(i: Int, k: Int): Int = {
      val pos = stones(i) + k
      val j = binarySearch(n, stones(_) >= pos)
      if(j < n && j > i && stones(j) == pos) {
        j
      } else {
        -1
      }
    }

    for {
      i <- 0 until n - 1
      k <- 0 until i + 1
    } {
      if(dp(i)(k)) {
        //try jump k
        val a = findNextPos(i, k)
        if(a > i) {
          dp(a)(k) = true
        }
        val b = findNextPos(i, k + 1)
        if(b > i) {
          dp(b)(k+1) = true
        }
        if(k > 1) {
          val c = findNextPos(i, k - 1)
          if(c > i) {
            dp(c)(k-1) = true
          }
        }
      }
    }
    dp(n-1).exists(identity)
  }

  private def binarySearch(n: Int, fn: Int => Boolean): Int = {
    var left = 0
    var right = n
    while(left < right) {
      val mid = (left + right) / 2
      if(fn(mid)) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    right
  }
}
