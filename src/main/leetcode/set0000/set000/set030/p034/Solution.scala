package set0000.set000.set030.p034

object Solution {

  def searchRange(nums: Array[Int], target: Int): Array[Int] = {
    val i = binarySearch(nums.length, i => nums(i) > target)
    if (i == 0 || nums(i - 1) < target) {
      Array(-1, -1)
    } else {
      val j = binarySearch(nums.length, j => nums(j) >= target)
      Array(j, i - 1)
    }
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
