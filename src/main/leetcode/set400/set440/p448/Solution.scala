package set400.set440.p448

import scala.collection.mutable.ArrayBuffer

object Solution {
  def findDisappearedNumbers(nums: Array[Int]): List[Int] = {
    for {
      i <- nums.indices
    } {
      val x = nums(i).abs
      if(nums(x - 1) > 0) {
        nums(x - 1) = -nums(x-1)
      }
    }
    val res = ArrayBuffer.empty[Int]
    for {
      i <- nums.indices
    } {
      if(nums(i) > 0) {
        res += (i + 1)
      }
    }
    res.toList
  }
}
