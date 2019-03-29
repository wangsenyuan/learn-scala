package set400.set470.p477

object Solution {
  def totalHammingDistance(nums: Array[Int]): Int = {
    val n = nums.length
    var res = 0
    for {
      i <- 0 until 31
    } {
      val a = nums.count(num => ((num >> i) & 1) == 0)
      val b = n - a
      res += a * b
    }
    res
  }
}
