package set800.set870.p875

object Solution {
  def minEatingSpeed(piles: Array[Int], H: Int): Int = {
    val n = piles.length

    def check(k: Int): Boolean = {
      var h = 0
      var i = 0
      while (i < n && h < H) {
        h += (piles(i) + k - 1) / k
        i += 1
      }
      i == n && h <= H
    }

    var left = 1
    var right = piles.max + 1
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
