package set1000.set1000.set1010.p1011

object Solution {
  def shipWithinDays(weights: Array[Int], D: Int): Int = {
    val n = weights.length

    def check(cap: Int): Boolean = {
      var x = 0
      var w = 0
      var i = 0
      while (i < n) {
        w += weights(i)
        if (w > cap) {
          w = weights(i)
          x += 1
        }
        i += 1
      }
      if (w > 0) {
        x += 1
      }
      x <= D
    }

    var left = weights.max
    var right = weights.sum

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
