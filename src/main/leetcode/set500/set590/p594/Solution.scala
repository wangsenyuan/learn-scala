package set500.set590.p594

import scala.collection.mutable
import scala.util.Sorting

object Solution {
  def findLHS(nums: Array[Int]): Int = {
    val count = mutable.Map.empty[Int, Int].withDefaultValue(0)

    for {
      num <- nums
    } {
      count(num) += 1
    }

    var best = 0

    for {
      (k, v) <- count
      if(count.contains(k - 1))
    } {
      best = best max (v + count(k - 1))
    }

    best
  }

  def findLHS1(nums: Array[Int]): Int = {
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
