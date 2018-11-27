package set000.set010.p011

object Solution {
  def maxArea(height: Array[Int]): Int = {
    val n = height.size
    var best = 0
    var i = 0
    var j = n - 1
    while (i < j) {
      val vol = (j - i) * (height(i) min height(j))
      best = best max vol
      if (height(i) < height(j)) {
        i += 1
      } else {
        j -= 1
      }
    }
    best
  }
}
