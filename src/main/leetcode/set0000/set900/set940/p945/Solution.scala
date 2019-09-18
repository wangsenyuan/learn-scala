package set0000.set900.set940.p945

import scala.util.Sorting

object Solution {
  def minIncrementForUnique(A: Array[Int]): Int = {
    val n = A.length
    if (n == 0) {
      0
    } else {
      Sorting.quickSort(A)

      var ans = 0
      var cap = A(0)
      var i = 1
      while (i < n) {
        if (A(i) <= cap) {
          ans += cap + 1 - A(i)
          A(i) = cap + 1
        }
        cap = A(i)
        i += 1
      }
      ans
    }
  }
}
