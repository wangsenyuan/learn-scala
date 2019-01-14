package set200.set220.p221

object Solution {
  def maximalSquare(matrix: Array[Array[Char]]): Int = {
    if (matrix.length == 0 || matrix(0).length == 0) {
      0
    } else {
      val m = matrix.length
      val n = matrix(0).length
      val dp = Array.ofDim[Int](m + 1, n + 1)

      for {
        i <- 0 until m
        j <- 0 until n
      } {
        dp(i + 1)(j + 1) = dp(i)(j + 1) + dp(i + 1)(j) + (matrix(i)(j) - '0') - dp(i)(j)
      }

      def check(w: Int): Boolean = {
        var found = false
        var i = w
        while (i <= m && !found) {
          var j = w
          while (j <= n && !found) {
            val a = i - w
            val b = j - w
            val area = dp(i)(j) - dp(i)(b) - dp(a)(j) + dp(a)(b)
            found = area == w * w
            j += 1
          }
          i += 1
        }
        found
      }

      var left = 0
      var right = (m min n) + 1
      while (left < right) {
        val mid = (left + right) / 2
        if (!check(mid)) {
          right = mid
        } else {
          left = mid + 1
        }
      }
      (left - 1) * (left - 1)
    }
  }
}
