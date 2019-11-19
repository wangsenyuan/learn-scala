package set1000.set1100.set1120.p1124

object Solution {
  def longestWPI(hours: Array[Int]): Int = {
    val n = hours.length
    val stack = Array.ofDim[(Int, Int)](n + 1)
    var p = 0
    stack(p) = 0 -> -1
    p += 1
    var sum = 0

    var best = 0
    var i = 0
    while (i < n) {
      sum += convert(hours(i))

      val j = search(p, k => stack(k)._1 < sum)

      if (j < p) {
        best = best max (i - stack(j)._2)
      }

      if (p == 0 || stack(p - 1)._1 > sum) {
        stack(p) = sum -> i
        p += 1
      }
      i += 1
    }

    best
  }

  private def search(n: Int, fn: Int => Boolean): Int = {
    var left = 0
    var right = n
    while (left < right) {
      val mid = (left + right) / 2
      if (fn(mid)) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    right
  }

  private def convert(h: Int) = if (h > 8) 1 else -1
}
