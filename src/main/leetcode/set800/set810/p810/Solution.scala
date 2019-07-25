package set800.set810.p810

object Solution {

  def xorGame(nums: Array[Int]): Boolean = {
    val n = nums.length
    val r = nums.reduce(_ ^ _)

    r == 0 || (n & 1) == 0
  }
}
