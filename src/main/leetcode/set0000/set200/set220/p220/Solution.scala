package set0000.set200.set220.p220

import java.util

object Solution {
  def containsNearbyAlmostDuplicate(nums: Array[Int], k: Int, t: Int): Boolean = {
    if (k == 0 || t < 0) {
      false
    } else {
      val map = new util.TreeMap[Long, Int]()

      var duplicate = false
      var i = 0
      while (i < nums.length && !duplicate) {
        val num = nums(i).toLong

        val up = map.ceilingEntry(num)
        val low = map.floorEntry(num)

        duplicate = if (up != null && up.getKey - num <= t) {
          true
        } else if (low != null && num - low.getKey <= t) {
          true
        } else {
          duplicate
        }

        if (i >= k) {
          map.remove(nums(i - k).toLong)
        }

        map.put(num, i)

        i += 1
      }
      duplicate
    }
  }
}
