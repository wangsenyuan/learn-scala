package set0000.set200.set270.p274

object Solution {
  def hIndex(citations: Array[Int]): Int = {
    val n = citations.length
    if (n == 0) {
      0
    } else {
      def check(h: Int): Boolean = {
        citations.count(_ >= h) >= h
      }

      var left = 1
      //check(right) == false
      var right = n + 1
      while (left < right) {
        val mid = (left + right) / 2
        if (check(mid)) {
          left = mid + 1
        } else {
          right = mid
        }
      }
      left - 1
    }
  }
}
