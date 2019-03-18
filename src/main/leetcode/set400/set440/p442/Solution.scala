package set400.set440.p442

import scala.collection.mutable.{ArrayBuffer}

object Solution {
  def findDuplicates(nums: Array[Int]): List[Int] = {
    val res = ArrayBuffer.empty[Int]

    val n = nums.size
    var i = 0
    while(i < n) {
      val x = nums(i).abs
      nums(x - 1) = -nums(x-1)
      if(nums(x - 1) > 0) {
        res += x
      }
      i += 1
    }

    res.toList
  }
}
