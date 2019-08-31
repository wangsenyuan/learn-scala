package set0000.set800.set890.p891

import scala.util.Sorting

object Solution {
  val MOD = 1000000007L

  def sumSubseqWidths(A: Array[Int]): Int = {
    if (A.length <= 1) {
      0
    } else {
      Sorting.quickSort(A)

      var prev = (A(1) - A(0)).toLong
      var sum = prev
      var cnt = 1L
      var acc = 1L
      var i = 2
      while (i < A.length) {
        var cur = 2 * cnt * (A(i) - A(i - 1)) + 2 * prev + A(i) - A(i - 1)
        cur %= MOD
        sum += cur
        sum %= MOD
        prev = cur
        acc *= 2
        acc %= MOD
        cnt += acc
        cnt %= MOD
        i += 1
      }

      sum.toInt
    }
  }
}
