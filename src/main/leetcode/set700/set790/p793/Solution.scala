package set700.set790.p793

object Solution {
  def preimageSizeFZF(K: Int): Int = {
    val i = search(Long.MaxValue, count(_) > K)
    val j = search(Long.MaxValue, count(_) >= K)
    (i - j).toInt
  }

  private def search(n: Long, fn: Long => Boolean): Long = {
    var left = 0L
    var right = n
    while(left < right) {
      val mid = left + (right - left) / 2
      if(fn(mid)) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    right
  }

  private def count(x: Long): Long = {
    var res = 0L
    var f = 5L

    while(f <= x) {
      res += x / f
      f *= 5
    }
    res
  }
}
