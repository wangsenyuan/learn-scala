package set500.set560.p560

import scala.collection.mutable

object Solution {
  def subarraySum(nums: Array[Int], k: Int): Int = {
    val count = mutable.Map.empty[Int, Int].withDefaultValue(0)
    count(0) = 1
    var res = 0
    var sum = 0
    for {
      num <- nums
    } {
      sum += num
      res += count(sum - k)
      count(sum) += 1
    }
    res
  }
}
