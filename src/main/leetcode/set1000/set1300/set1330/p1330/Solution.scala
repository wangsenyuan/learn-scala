package set1000.set1300.set1330.p1330

object Solution {
  def maxValueAfterReverse(nums: Array[Int]): Int = {
    var total = 0
    var res = 0
    var min2 = 123456
    var max2 = -123456
    val n = nums.length
    var i = 0
    while (i < n - 1) {
      val a = nums(i)
      val b = nums(i + 1)
      total += (a - b).abs
      res = res max ((nums(0) - b).abs - (a - b).abs)
      res = res max ((nums(n - 1) - a).abs - (a - b).abs)

      min2 = min2 min (a max b)
      max2 = max2 max (a min b)
      i += 1
    }

    total + (res max (max2 - min2) * 2)
  }
}
