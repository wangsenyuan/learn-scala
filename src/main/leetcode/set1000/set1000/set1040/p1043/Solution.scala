package set1000.set1000.set1040.p1043

object Solution {
  def maxSumAfterPartitioning(A: Array[Int], K: Int): Int = {
    val n = A.length
    val dp = Array.ofDim[Int](n + 1)
    //dp(i) = max sum before or at i
    var i = 0
    while (i < n) {
      var x = A(i)
      var j = 0
      while (j < K && i - j >= 0) {
        x = x max A(i - j)

        val s = x * (j + 1)

        dp(i + 1) = dp(i + 1) max (s + dp(i - j))

        j += 1
      }


      i += 1
    }

    dp(n)
  }
}
