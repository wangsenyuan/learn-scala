package set1000.set1200.set1200.p1208

object Solution {
  def equalSubstring(s: String, t: String, maxCost: Int): Int = {
    val n = s.length
    val costs = Array.ofDim[Int](n + 1)
    for {
      i <- 0 until n
    } {
      costs(i + 1) = costs(i) + (s(i) - t(i)).abs
    }

    def check(len: Int): Boolean = {
      var i = 0
      while (i + len <= n && costs(i + len) - costs(i) > maxCost) {
        i += 1
      }
      i + len <= n
    }

    var left = 1
    var right = n + 1
    while (left < right) {
      val mid = (left + right) / 2
      if (!check(mid)) {
        right = mid
      } else {
        left = mid + 1
      }
    }

    right - 1
  }
}
