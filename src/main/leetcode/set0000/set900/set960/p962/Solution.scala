package set0000.set900.set960.p962

import scala.util.Sorting

object Solution {
  def maxWidthRamp(A: Array[Int]): Int = {
    val ai = A.zipWithIndex
    Sorting.quickSort(ai)(Ordering.fromLessThan((a, b) => a._1 < b._1 || (a._1 == b._1 && a._2 < b._2)))

    var left = ai.length
    var best = 0
    var i = 0
    while (i < ai.length) {
      val j = ai(i)._2

      best = best max (j - left)

      left = left min j
      i += 1
    }
    best
  }
}
