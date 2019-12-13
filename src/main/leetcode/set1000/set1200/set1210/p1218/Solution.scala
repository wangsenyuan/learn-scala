package set1000.set1200.set1210.p1218

import scala.collection.mutable

object Solution {
  def longestSubsequence(arr: Array[Int], difference: Int): Int = {
    val cnt = mutable.Map.empty[Int, Int].withDefaultValue(0)

    var best = 0
    val n = arr.length

    var i = n - 1
    while (i >= 0) {
      val x = arr(i)
      val y = x + difference

      cnt(x) = cnt(x) max (cnt(y) + 1)

      best = best max cnt(x)

      i -= 1
    }

    best
  }
}
