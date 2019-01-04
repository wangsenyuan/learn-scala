package set100.set150.p154

object Solution {
  def findMin(nums: Array[Int]): Int = {
    var n = nums.length - 1
    while (n > 0 && nums(0) == nums(n)) {
      n -= 1
    }
    if (n == 0 || nums(0) < nums(n)) {
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
