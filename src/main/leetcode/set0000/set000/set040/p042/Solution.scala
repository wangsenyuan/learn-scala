package set0000.set000.set040.p042

object Solution {
  def trap(height: Array[Int]): Int = {
    val n = height.length
    if (n <= 2) {
      0
    } else {
      val left = Array.fill(n)(0)
      left(0) = height(0)
      var i = 1
      while (i < n) {
        left(i) = left(i - 1) max height(i)
        i += 1
      }
      val right = Array.fill(n)(0)
      right(n - 1) = height(n - 1)
      i = n - 2
      while (i >= 0) {
        right(i) = right(i + 1) max height(i)
        i -= 1
      }
      var res = 0
      i = 1
      while (i < n - 1) {
        val cap = left(i) min right(i)
        res += cap - height(i)
        i += 1
      }
      res
    }
  }
}
