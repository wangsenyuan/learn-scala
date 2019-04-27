package set500.set590.p594

import scala.util.Sorting

object Solution {
  def findLHS(nums: Array[Int]): Int = {
    Sorting.quickSort(nums)
    val n = nums.length
    var best = 0
    var j = 0
    var i = 1
    while(i <= n) {
      if(i == n || nums(i) > nums(i-1)) {
        val k = j
        j = i
        if(i < n && nums(i) == nums(i-1) + 1) {
          i += 1
          while(i < n && nums(i) == nums(i - 1)) {
            i += 1
          }
          best = best max (i - k)
          i -= 1
        }
      }
      i += 1
    }

    best
  }
}
