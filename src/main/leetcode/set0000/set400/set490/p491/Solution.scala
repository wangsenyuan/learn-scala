package set0000.set400.set490.p491

import scala.collection.mutable.ListBuffer

object Solution {
  def findSubsequences(nums: Array[Int]): List[List[Int]] = {
    val n = nums.length

    val res = ListBuffer.empty[List[Int]]

    def go(from: Int, cur: List[Int]): Unit = {
      if(cur.size > 1) {
        res += cur.reverse
      }

      var used = Set.empty[Int]

      for {
        i <- from + 1 until n
        if(!used(nums(i)))
      } {
        if(from < 0 || nums(i) >= nums(from)) {
          used += nums(i)
          go(i,  nums(i) :: cur)
        }
      }
    }

    go(-1,  Nil)

    res.toList
  }
}
