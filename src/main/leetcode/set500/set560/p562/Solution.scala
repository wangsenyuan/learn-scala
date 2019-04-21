package set500.set560.p562

import scala.util.Sorting

object Solution {
  def arrayPairSum(nums: Array[Int]): Int = {
    Sorting.quickSort(nums)
    var res = 0
    for {
      i <- 0 until nums.length by 2
    } {
      res += nums(i)
    }
    res
  }
}
