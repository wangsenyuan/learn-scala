package set1000.set1100.set1180.p1186

object Solution {
  def maximumSum(arr: Array[Int]): Int = {
    val n = arr.length

    if (n == 1) {
      arr(0)
    } else {
      val dp = Array.ofDim[Int](n)
      var i = 0
      while (i < n) {
        dp(i) = arr(i)
        if (i > 0) {
          dp(i) = dp(i) max (arr(i) + dp(i - 1))
        }
        i += 1
      }
      val fp = Array.ofDim[Int](n)
      i = n - 1
      while (i >= 0) {
        fp(i) = arr(i)
        if (i < n - 1) {
          fp(i) = fp(i) max (arr(i) + fp(i + 1))
        }
        i -= 1
      }

      var best = arr(0) max fp(0)
      i = 1
      while (i < n - 1) {
        val a = dp(i - 1)
        val b = fp(i + 1)
        best = best max (a + arr(i) + b) max (a + b) max (a + arr(i)) max (arr(i) + b) max arr(i) max a max b
        i += 1
      }

      best = best max arr(n - 1) max dp(n - 1)

      best
    }
  }
}
