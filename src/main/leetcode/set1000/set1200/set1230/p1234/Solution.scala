package set1000.set1200.set1230.p1234

object Solution {
  val II = Map('Q' -> 0, 'W' -> 1, 'R' -> 2, 'E' -> 3)

  def balancedString(s: String): Int = {
    val n = s.length

    val dp = Array.ofDim[Int](n + 1, 4)

    var i = 0
    while (i < n) {
      (0 until 4).foreach(j => dp(i + 1)(j) = dp(i)(j))
      dp(i + 1)(II(s(i))) += 1

      i += 1
    }

    val m = n / 4

    def check(len: Int): Boolean = {
      var found = false
      var i = 0
      while (i + len <= n && !found) {
        // replace substring [i...i+len]
        val q = dp(n)(0) - dp(i + len)(0) + dp(i)(0)
        val w = dp(n)(1) - dp(i + len)(1) + dp(i)(1)
        val r = dp(n)(2) - dp(i + len)(2) + dp(i)(2)
        val e = dp(n)(3) - dp(i + len)(3) + dp(i)(3)

        if (q <= m && w <= m && r <= m && e <= m) {
          found = m - q + m - w + m - r + m - e == len
        }

        i += 1
      }

      found
    }

    var left = 0
    var right = n

    while (left < right) {
      val mid = (left + right) / 2
      if (check(mid)) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    right
  }
}
