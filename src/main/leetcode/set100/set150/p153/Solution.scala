package set100.set150.p153

object Solution {
  def findMin(nums: Array[Int]): Int = {
    val n = nums.length
    if (n == 1) {
      nums(0)
    } else if (nums(0) < nums(n - 1)) {
      nums(0)
    } else {
      var i = 0
      var j = n
      while (i < j) {
        val mid = (i + j) / 2
        if (nums(mid) < nums(0)) {
          j = mid
        } else {
          i = mid + 1
        }
      }
      nums(i)
    }
  }
}
