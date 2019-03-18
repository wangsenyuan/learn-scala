package set400.set440.p441

object Solution {
  def arrangeCoins(n: Int): Int = {
    val x = binarySearch(n.toLong + 1, m => (m * (m + 1) / 2 > n))
    x.toInt - 1
  }

  private def binarySearch(n: Long, fn: Long => Boolean): Long = {
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
}
