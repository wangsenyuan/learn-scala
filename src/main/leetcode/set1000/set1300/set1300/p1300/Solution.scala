package set1000.set1300.set1300.p1300

import scala.util.Sorting

object Solution {
  def findBestValue(arr: Array[Int], target: Int): Int = {
    var diff = Int.MaxValue
    var ans = -1

    Sorting.quickSort(arr)

    val n = arr.length
    var sum = 0

    var i = 0
    while (i < arr.length) {
      // sum + x * (n - i) == target
      if (sum <= target) {
        val x = (target - sum) / (n - i)
        if (x >= 0 && x <= arr(i) && (i == 0 || x >= arr(i - 1))) {
          val d = (sum + x * (n - i) - target).abs
          if (d < diff) {
            ans = x
            diff = d
          }
        }
        val y = x + 1
        if (y >= 0 && y <= arr(i) && (i == 0 || y >= arr(i - 1))) {
          val d = (sum + y * (n - i) - target).abs
          if (d < diff) {
            ans = y
            diff = d
          }
        }
      }

      sum += arr(i)

      i += 1
    }

    ans
  }
}
