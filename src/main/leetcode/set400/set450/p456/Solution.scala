package set400.set450.p456

import java.util

object Solution {
  def find132pattern(nums: Array[Int]): Boolean = {
    val n = nums.length

    if(n < 3) {
      false
    } else {
      val tree = new util.TreeMap[Int, Boolean]()
      val right = Array.fill(n)(Int.MinValue)

      var i = n - 1
      while(i >= 0) {
        val tmp = tree.floorEntry(nums(i) - 1)
        if(tmp != null) {
          right(i) = tmp.getKey()
        }
        tree.put(nums(i), true)

        i -= 1
      }
      var found = false
      var minNum = nums(0)
      i = 1
      while(i < n - 1 && !found) {
        if(minNum < nums(i)) {
          if(right(i) > minNum) {
            found = true
          }
        }

        minNum = minNum min nums(i)

        i += 1
      }

      found
    }
  }
}
