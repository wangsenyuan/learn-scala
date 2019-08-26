package set0000.set000.set040.p040

import scala.collection.mutable.ListBuffer

object Solution {
  def combinationSum2(candidates: Array[Int], target: Int): List[List[Int]] = {
    val nums = candidates.sorted
    val res = ListBuffer.empty[List[Int]]
    val n = nums.length

    def go(i: Int, target: Int, can: List[Int]): Unit = {
      if (target == 0) {
        res += can.reverse
      } else if (i < n && target >= nums(i)) {
        go(i + 1, target - nums(i), nums(i) :: can)
        go(i + 1, target, can)
      }
    }

    go(0, target, Nil)

    res.distinct.toList
  }
}
