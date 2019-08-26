package set0000.set600.set640.p645

object Solution {
  def findErrorNums(nums: Array[Int]): Array[Int] = {
    val n = nums.length
    val sum = nums.sum
    val diff = sum - n * (n + 1) / 2
    var i = 0
    while (i < n && nums(nums(i).abs - 1) > 0) {
      nums(nums(i).abs - 1) *= -1
      i += 1
    }

    val x = nums(i).abs

    Array(x, x - diff)
  }
}
