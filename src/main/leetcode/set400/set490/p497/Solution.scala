package set400.set490.p497

import scala.util.Random

class Solution(_rects: Array[Array[Int]]) {

  private def pointCount(rect: Array[Int]): Int = {
    val x1 = rect(0)
    val y1 = rect(1)
    val x2 = rect(2)
    val y2 = rect(3)
    (y2 - y1 + 1) * (x2 - x1 + 1)
  }

  val n = _rects.length

  val rand = new Random()

  val counts = _rects.map(pointCount)

  for {
    i <- 1 until n
  } {
    counts(i) += counts(i-1)
  }

  val total = counts(n-1)

  def pick(): Array[Int] = {
    val a = rand.nextInt(total) + 1

    val i = binarySearch(n, counts(_) >= a)

    val rect = _rects(i)
    val x1 = rect(0)
    val y1 = rect(1)
    val x2 = rect(2)
    val y2 = rect(3)
    val w = x2 - x1 + 1
    val h = y2 - y1 + 1
    val j = rand.nextInt(w * h)

    val x = j % w
    val y = j / w

    Array(x1 + x, y1 + y)
  }

  private def binarySearch(n: Int, fn: Int => Boolean): Int = {
    var left = 0
    var right = n
    while (left < right) {
      val mid = left + (right - left) / 2
      if (fn(mid)) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    left
  }
}
