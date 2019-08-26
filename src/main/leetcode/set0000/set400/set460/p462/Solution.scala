package set0000.set400.set460.p462

import scala.util.Sorting

object Solution {
  def minMoves2(nums: Array[Int]): Int = {
    Sorting.quickSort(nums)
    val n = nums.length
    val sum = (nums.sum).toLong
    var best = Long.MaxValue
    var s = 0L
    for {
      i <- nums.indices
    } {
      s += nums(i).toLong
      val tmp = (i + 1).toLong * nums(i).toLong - s + sum - s - (n - i - 1).toLong * nums(i).toLong
      best = best min tmp
    }
    best.toInt
  }
}
