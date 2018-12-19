package set000.set080.p084

object Solution {
  def largestRectangleArea(heights: Array[Int]): Int = {
    if (heights.isEmpty) {
      0
    } else {
      calculate(heights, heights.length)
    }
  }

  private def calculate(heights: Array[Int], n: Int): Int = {
    val stack = Array.fill(n)(0)
    var best = 0
    var p = 0
    for {
      i <- 0 until n
    } {
      var k = i
      while (p > 0 && heights(stack(p - 1)) > heights(i)) {
        val j = stack(p - 1)
        best = best max heights(j) * (i - j)
        heights(j) = heights(i)
        p -= 1
        k = j
      }
      stack(p) = k
      p += 1
      best = best max heights(i)
    }

    while (p > 0) {
      val i = stack(p - 1)
      p -= 1
      best = best max (n - i) * heights(i)
    }
    best
  }

}
