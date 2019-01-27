package set200.set280.p283

object Solution {
  def moveZeroes(nums: Array[Int]): Unit = {
    val n = nums.length
    var j = 0

    var i = 0
    while (i < n) {
      if (nums(i) != 0) {
        nums(j) = nums(i)
        j += 1
      }
      i += 1
    }

    while (j < n) {
      nums(j) = 0
      j += 1
    }
  }
}
