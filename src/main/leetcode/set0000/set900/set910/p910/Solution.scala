package set0000.set900.set910.p910

import scala.util.Sorting

object Solution {
  def smallestRangeII(A: Array[Int], K: Int): Int = {
    Sorting.quickSort(A)

    val n = A.length

    if (n <= 1 || A(0) == A(n - 1)) {
      0
    } else {
      var best = A(n - 1) - A(0)
      val arr = Array.ofDim[Int](4)
      var i = 0
      while (i < n - 1) {
        // all indexes j <= i, increment by K
        // all indexes j > i, decrement by K
        arr(0) = A(0) + K
        arr(1) = A(i) + K
        arr(2) = A(i + 1) - K
        arr(3) = A(n - 1) - K

        val a = arr.min
        val b = arr.max

        best = best min (b - a)

        i += 1
      }

      best
    }
  }
}
