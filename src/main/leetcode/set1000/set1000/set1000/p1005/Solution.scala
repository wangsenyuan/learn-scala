package set1000.set1000.set1000.p1005

import scala.util.Sorting

object Solution {
  def largestSumAfterKNegations(A: Array[Int], K: Int): Int = {
    Sorting.quickSort(A)

    val n = A.length
    var k = K
    var i = 0

    var sum = 0
    while (i < n && A(i) < 0 && k > 0) {
      sum += -A(i)
      i += 1
      k -= 1
    }

    if (k % 2 == 0) {
      // safe to add left
      while (i < n) {
        sum += A(i)
        i += 1
      }
      sum
    } else {
      // need to use one more times
      if (i == 0 || A(i) < A(i - 1).abs) {
        // -2, 1
        sum -= A(i)
        i += 1
      } else {
        sum += A(i - 1)
        i -= 1
      }

      while (i < n) {
        sum += A(i)
        i += 1
      }

      sum
    }

  }
}
