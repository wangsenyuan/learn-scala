package set1000.set1000.set1000.p1000

object Solution {
  def mergeStones(stones: Array[Int], K: Int): Int = {
    val n = stones.length

    val INF = 1 << 20

    val sum = Array.ofDim[Int](n + 1)
    (0 until n).foreach(i => sum(i + 1) = sum(i) + stones(i))

    val dp = Array.fill(n, n, K + 1)(-1)

    def dfs(i: Int, j: Int, m: Int): Int = {
      val len = j - i + 1
      if ((len - m) % (K - 1) != 0) {
        INF
      } else if (len == 1) {
        if (m == 1) {
          0
        } else {
          INF
        }
      } else if (dp(i)(j)(m) >= 0) {
        dp(i)(j)(m)
      } else if (m == 1) {
        val res = dfs(i, j, K) + sum(j + 1) - sum(i)
        dp(i)(j)(m) = res
        res
      } else {
        var res = INF
        for {
          mid <- i until j
        } {
          val tmp = dfs(i, mid, 1) + dfs(mid + 1, j, m - 1)
          res = res min tmp
        }
        dp(i)(j)(m) = res
        res
      }
    }


    val res = dfs(0, n - 1, 1)
    if (res >= INF) {
      -1
    } else {
      res
    }
  }
}
