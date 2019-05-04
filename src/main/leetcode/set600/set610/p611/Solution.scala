package set600.set610.p611

import scala.util.Sorting

object Solution {
  def triangleNumber(nums: Array[Int]): Int = {
    Sorting.quickSort(nums)
    val n = nums.length
    var res = 0
    for {
      i <- 0 until n
      j <- i + 1 until n
    } {
      val k = binarySearch(n, nums(_) >= nums(i) + nums(j)) - 1
      res += (k - j) max 0
    }

    res
  }

  private def binarySearch(n: Int, fn: Int => Boolean): Int = {
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
