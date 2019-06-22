package set700.set750.p757

import java.util

import scala.util.Sorting

object Solution {
  def intersectionSizeTwo(intervals: Array[Array[Int]]): Int = {
    val n = intervals.length
    if (n == 0) {
      0
    } else if (n == 1) {
      2
    } else {
      Sorting.quickSort(intervals)(Ordering.fromLessThan((a, b) => {
        a(0) < b(0) || (a(0) == b(0) && a(1) > b(1))
      }))
      val set = new util.TreeSet[Int]()
      var i = n - 1
      while (i >= 0) {
        val cur = intervals(i)
        val a = cur(0)
        val b = cur(1)
        val sub = set.subSet(a, b + 1)
        if (sub.size() == 0) {
          set.add(a)
          set.add(a + 1)
        } else if (sub.size() == 1) {
          set.add(a)
        }
        i -= 1
      }

      set.size()
    }
  }
}
