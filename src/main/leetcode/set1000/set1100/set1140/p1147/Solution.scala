package set1000.set1100.set1140.p1147

object Solution {
  val MOD = 10000000000007L

  def longestDecomposition(text: String): Int = {
    val n = text.length
    val dp = Array.ofDim[Int](n, n)

    for {
      i <- 0 until n
      j <- i until n
    } {
      dp(i)(j) = -1
    }

    val B = 31L

    def dfs(x: Int, y: Int): Int = {
      if (x > y) {
        0
      } else if (dp(x)(y) >= 0) {
        dp(x)(y)
      } else {
        var best = 1

        var k = 0
        var left = 0L
        var right = 0L
        var bb = 1L

        while (x + k < y - k) {
          left = (left * B + text.charAt(x + k) - 'a') % MOD
          right = ((text.charAt(y - k) - 'a') * bb + right) % MOD
          bb = (bb * B) % MOD
          if (left == right) {
            val tmp = 2 + dfs(x + k + 1, y - k - 1)
            best = best max tmp
          }
          k += 1
        }


        dp(x)(y) = best
        best
      }
    }

    dfs(0, n - 1)
  }
}
