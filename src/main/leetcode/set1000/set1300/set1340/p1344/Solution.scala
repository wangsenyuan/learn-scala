package set1000.set1300.set1340.p1344

import scala.util.Sorting

object Solution {
  def maxJumps(arr: Array[Int], d: Int): Int = {
    val n = arr.length
    val can = Array.ofDim[Boolean](n, n)

    var i = 0
    while (i < n) {
      var j = i - 1
      while (j >= 0 && arr(j) < arr(i) && (i - j) <= d) {
        can(j)(i) = true
        j -= 1
      }

      j = i + 1
      while (j < n && arr(j) < arr(i) && j - i <= d) {
        can(j)(i) = true
        j += 1
      }

      i += 1
    }

    val arr2 = arr.zipWithIndex
    Sorting.quickSort(arr2)(Ordering.by(_._1))

    // at least one index (self)
    val dp = Array.fill(n)(1)

    i = 0
    while (i < n) {
      val cur = arr2(i)
      val ii = cur._2

      var j = 0
      while (j < n) {
        if (can(ii)(j)) {
          dp(j) = dp(j) max (dp(ii) + 1)
        }
        j += 1
      }

      i += 1
    }

    dp.max
  }
}
