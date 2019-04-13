package set500.set530.p532

import scala.util.Sorting

object Solution {
  def findPairs(nums: Array[Int], k: Int): Int = {
    Sorting.quickSort(nums)

    val n = nums.length
    var res = 0
    var i = 0
    while (i < n) {
      if (i == 0 || nums(i) > nums(i - 1)) {
        val j = binarySearch(n, nums(_) > nums(i) + k) - 1
        if (j > i && nums(j) == nums(i) + k) {
          res += 1
        }
      }

      i += 1
    }

    res
  }

  private def binarySearch(n: Int, fn: Int => Boolean): Int = {
    var left = 0
    var right = n
    while (left < right) {
      val mid = (left + right) / 2
      if (fn(mid)) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    left
  }
}
