package set500.set520.p525

import scala.collection.mutable

object Solution {
  def findMaxLength(nums: Array[Int]): Int = {
    val n = nums.length

    if (n == 0) {
      0
    } else {
      // s(i) = count of ones till i (including)
      // i - (j - 1) = 2 * (s(i) - s(j - 1))
      // => i - 2 * s(i) = (j - 1) - 2 * s(j - 1)
      val pref = mutable.Map.empty[Int, Int]
      var ans = 0
      var sum = 0
      var i = 1
      pref(0) = 0
      while(i <= n) {
        sum += nums(i-1)
        val x = i - 2 * sum
        if(pref.contains(x)) {
          val j = pref(x)
          ans = ans max (i - j)
        } else {
          pref(x) = i
        }

        i += 1
      }

      ans
    }
  }
}
