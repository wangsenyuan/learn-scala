package set0000.set200.set260.p260

object Solution {
  def singleNumber(nums: Array[Int]): Array[Int] = {
    val xs = nums.reduceLeft(_ ^ _)
    // xs = x ^ y
    // x = xs ^ y
    val x = xs & (-xs)

    val (a, b) = nums.partition(y => (x & y) == 0)
    Array(a.reduceLeft(_ ^ _), b.reduceLeft(_ ^ _))
  }
}
