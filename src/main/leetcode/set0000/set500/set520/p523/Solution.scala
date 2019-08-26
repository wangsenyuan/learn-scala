package set0000.set500.set520.p523

import scala.collection.mutable

object Solution {

  def findTwoZeros(nums: Array[Int]) = {
    var found = false
    var i = 1
    while (i < nums.length && !found) {
      found = nums(i) == 0 && nums(i - 1) == 0
      i += 1
    }
    found
  }

  def checkSubarraySum(nums: Array[Int], k: Int): Boolean = {
    val n = nums.length
    if (n <= 1) {
      false
    } else {
      val K = k.toLong.abs
      val twoZeros = findTwoZeros(nums)
      if (twoZeros) {
        true
      } else if (K == 0) {
        false
      } else if (K == 1) {
        true
      } else {
        val pre = mutable.Map.empty[Long, Int]
        pre(0) = -1
        var sum = 0L
        var found = false
        var i = 0
        while (i < n && !found) {
          sum += nums(i)
          var tmp = sum - K
          while (tmp >= 0 && !found) {
            if (pre.contains(tmp)) {
              val j = pre(tmp)
              found = i - j > 1
            }
            tmp -= K
          }

          if (!pre.contains(sum)) {
            pre(sum) = i
          }

          i += 1
        }

        found
      }
    }
  }
}
