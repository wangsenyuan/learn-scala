package set200.set210.p219

import scala.collection.mutable

object Solution {
  def containsNearbyDuplicate(nums: Array[Int], k: Int): Boolean = {
    val ii = mutable.Map.empty[Int, Int]

    var duplicate = false
    var i = 0

    while (i < nums.length && !duplicate) {
      val num = nums(i)
      if (ii.contains(num) && i - ii(num) <= k) {
        duplicate = true
      }
      ii(num) = i
      i += 1
    }
    duplicate
  }
}
