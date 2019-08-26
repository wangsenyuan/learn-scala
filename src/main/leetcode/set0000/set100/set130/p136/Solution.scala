package set0000.set100.set130.p136

object Solution {
  def singleNumber(nums: Array[Int]): Int = {
    if (nums.length == 1) {
      nums(0)
    } else {
      nums.reduce(_ ^ _)
    }
  }
}
