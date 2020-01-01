package set1000.set1200.set1290.p1296

import scala.collection.mutable
import scala.util.Sorting

object Solution {
  def isPossibleDivide(nums: Array[Int], k: Int): Boolean = {
    val cnt = mutable.Map.empty[Int, Int].withDefaultValue(0)

    nums.foreach(num => cnt(num) += 1)

    Sorting.quickSort(nums)

    var can = true

    var i = 0
    while (i < nums.length && can) {
      val num = nums(i)

      if (cnt(num) > 0) {
        var j = 0
        while (j < k && cnt(num + j) > 0) {
          cnt(num + j) -= 1
          j += 1
        }
        can = j == k
      }
      i += 1
    }
    can
  }
}
