package set0000.set000.set030.p033

object Solution {

  def search(nums: Array[Int], target: Int): Int = {
    def findPeak(left: Int, right: Int): Int = {
      val mid = (left + right) / 2
      if (nums(mid) > nums(mid + 1)) {
        mid
      } else {
        if (nums(mid) > nums(right)) {
          findPeak(mid, right)
        } else {
          findPeak(left, mid)
        }
      }
    }

    val n = nums.length
    if (n == 0) {
      -1
    } else if (n == 1) {
      if (nums(0) == target) {
        0
      } else {
        -1
      }
    } else if (nums(0) < nums(n - 1)) {
      // already sorted
      binarySearch(nums, 0, n, target)
    } else {
      val k = findPeak(0, n - 1)
      if (nums(0) <= target) {
        binarySearch(nums, 0, k + 1, target)
      } else {
        binarySearch(nums, k + 1, n, target)
      }
    }

  }

  private def binarySearch(nums: Array[Int], start: Int, end: Int, target: Int): Int = {
    var left = start
    var right = end
    while (left < right) {
      val mid = (left + right) / 2
      if (nums(mid) > target) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    // nums(right) > target
    if (right > 0 && nums(right - 1) == target) {
      right - 1
    } else {
      -1
    }
  }
}
