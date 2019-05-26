package set700.set700.p704

object Solution {

  def search(nums: Array[Int], target: Int): Int = {
    var left = 0
    var right = nums.length

    while (left < right) {
      val mid = (left + right) >> 1
      if (nums(mid) > target) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    left -= 1
    if (left >= 0 && nums(left) == target) {
      left
    } else {
      -1
    }
  }
}
