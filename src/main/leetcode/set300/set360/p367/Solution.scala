package set300.set360.p367

object Solution {
  def isPerfectSquare(num: Int): Boolean = {
    val x = num.toLong

    var left = 1L
    var right = 100000L
    while (left < right) {
      val mid = (left + right) >> 1
      if (mid * mid >= x) {
        right = mid
      } else {
        left = mid + 1
      }
    }

    right * right == x
  }
}
