package set0000.set000.set030.p035

object Solution {
  def searchInsert(nums: Array[Int], target: Int): Int = {
    binarySearch(nums.length, nums(_) >= target)
  }

  private def binarySearch(n: Int, fn: Int => Boolean): Int = {
    var left = 0
    var right = n
    while (left < right) {
      val mid = left + (right - left) / 2
      if (fn(mid)) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    right
  }
}
