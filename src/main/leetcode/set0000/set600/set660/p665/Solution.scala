package set0000.set600.set660.p665

object Solution {

  def checkSorted(nums: Array[Int]) = {
    var i = 0
    while (i < nums.length - 1 && nums(i) <= nums(i + 1)) {
      i += 1
    }
    i == nums.length - 1
  }

  def checkPossibility(nums: Array[Int]): Boolean = {
    val n = nums.length
    var i = 0
    while (i < n - 1 && nums(i) <= nums(i + 1)) {
      i += 1
    }

    if (i == n - 1) {
      true
    } else {
      // i & i + 1 is the first pair that
      // try change i lower first
      val numi = nums(i)
      if (i == 0) {
        nums(i) = Int.MinValue
      } else {
        nums(i) = nums(i - 1)
      }
      val can = checkSorted(nums)
      if (can) {
        true
      } else {
        nums(i) = numi
        if (i + 1 == n - 1) {
          nums(i + 1) = Int.MaxValue
        } else {
          nums(i + 1) = nums(i + 2)
        }
        checkSorted(nums)
      }
    }
  }
}
