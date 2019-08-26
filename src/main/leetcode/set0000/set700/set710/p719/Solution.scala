package set0000.set700.set710.p719

import scala.util.Sorting

object Solution {
  val MAX = 1000000

  def smallestDistancePair(nums: Array[Int], k: Int): Int = {
    Sorting.quickSort(nums)
    val n = nums.length

    def count(diff: Int): Int = {
      var cnt = 0
      var i = 0
      while(i < n) {
        val j = search(n, j => nums(j) - nums(i) > diff)
        cnt += (j - i - 1)
        i += 1
      }

      cnt
    }

    search(MAX, count(_) >= k)
  }

  private def search(n: Int, fn: Int => Boolean): Int = {
    var left = 0
    var right = n
    while(left < right) {
      val mid = (left + right) / 2
      if(fn(mid)) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    right
  }
}
