package set000.set040.p041

object Solution {
  def firstMissingPositive(nums: Array[Int]): Int = {
    var j = 0
    var i = 0
    var n = nums.length
    //remove negative numbers
    while (i < n) {
      if (nums(i) > 0) {
        nums(j) = nums(i)
        j += 1
      }
      i += 1
    }
    n = j
    i = 0
    while (i < n) {
      // number exceeds n doesn't matter
      if (nums(i).abs <= n) {
        val j = nums(i).abs - 1
        // indicate nums(i) there
        if (nums(j) > 0) {
          nums(j) = -nums(j)
        }
      }
      i += 1
    }

    i = 0
    while (i < n && nums(i) < 0) {
      i += 1
    }
    i + 1
  }
}
