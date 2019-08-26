package set0000.set800.set810.p813

object Solution {
  def largestSumOfAverages(A: Array[Int], K: Int): Double = {
    val n = A.length
    val dp = Array.fill[Double](n + 1, K + 1)(Double.MinValue)
    dp(0)(0) = 0.0
    var i = 1
    while (i <= n) {
      var k = K min i
      while (k > 0) {
        var sum = A(i - 1).toDouble
        var j = i - 1
        while (j >= 0) {
          dp(i)(k) = dp(i)(k) max (dp(j)(k - 1) + sum / (i - j))
          if (j > 0) {
            sum += A(j - 1)
          }
          j -= 1
        }

        k -= 1
      }
      i += 1
    }

    dp(n)(K)
  }
}
