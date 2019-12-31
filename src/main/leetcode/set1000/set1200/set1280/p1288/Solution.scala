package set1000.set1200.set1280.p1288

import scala.util.Sorting

object Solution {
  def removeCoveredIntervals(intervals: Array[Array[Int]]): Int = {
    val n = intervals.size
    Sorting.quickSort(intervals)(Ordering.fromLessThan(compareInterval))

    var res = n
    var boundary = intervals(0)(1)
    var i = 1
    while (i < n) {
      val cur = intervals(i)
      if (cur(1) <= boundary) {
        res -= 1
      }

      boundary = boundary max cur(1)
      i += 1
    }

    res
  }

  private def compareInterval(a: Array[Int], b: Array[Int]): Boolean = {
    if (a(0) < b(0)) {
      true
    } else if (a(0) == b(0) && a(1) > b(1)) {
      true
    } else {
      false
    }
  }
}
