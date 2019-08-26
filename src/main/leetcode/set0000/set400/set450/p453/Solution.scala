package set0000.set400.set450.p453

object Solution {
  def minMoves(nums: Array[Int]): Int = {
    val n = nums.length
    val min = nums.min
    nums.sum - min * n
  }
}
