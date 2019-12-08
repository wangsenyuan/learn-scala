package set1000.set1100.set1180.p1187

import scala.util.Sorting

object Solution {
  val INF = 1 << 30

  def makeArrayIncreasing(arr1: Array[Int], arr2: Array[Int]): Int = {

    Sorting.quickSort(arr2)

    var n = 0

    var i = 1
    while (i <= arr2.length) {
      if (i == arr2.length || arr2(i) > arr2(i - 1)) {
        arr2(n) = arr2(i - 1)
        n += 1
      }
      i += 1
    }

    val m = arr1.length

    // dp(i)(j) = cnt of ops, make arr1[i] ends at arr2[j - 1],
    val dp = Array.fill[Int](m, n + 1)(INF)
    dp(0)(0) = 0

    for {
      j <- 0 until n
    } {
      dp(0)(j + 1) = 1
    }

    i = 0
    while (i < m - 1) {
      // try with (i + 1)
      var j = 0
      if (dp(i)(0) < INF) {
        // already sorted
        if (arr1(i + 1) > arr1(i)) {
          dp(i + 1)(0) = dp(i)(0)
        }
        while (j < n && arr2(j) <= arr1(i)) {
          j += 1
        }
        if (j < n) {
          dp(i + 1)(j + 1) = dp(i)(0) + 1
        }
      }

      j = 0
      while (j < n) {
        if (dp(i)(j + 1) < INF) {
          // try assign arr2(j+1) to arr1(i + 1)
          if (arr1(i + 1) > arr2(j)) {
            // already sorted
            dp(i + 1)(0) = dp(i + 1)(0) min dp(i)(j + 1)
          }
          if (j < n - 1) {
            dp(i + 1)(j + 2) = dp(i + 1)(j + 2) min (dp(i)(j + 1) + 1)
          }
        }
        j += 1
      }
      i += 1
    }

    val res = dp(m - 1).min
    if (res < INF) {
      res
    } else {
      -1
    }
  }
}
