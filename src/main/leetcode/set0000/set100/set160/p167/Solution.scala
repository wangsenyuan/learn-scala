package set0000.set100.set160.p167

import scala.annotation.tailrec

object Solution {

  def twoSum(numbers: Array[Int], target: Int): Array[Int] = {
    @tailrec
    def go(i: Int): Array[Int] = {
      val j = binarySearch(i, numbers(_) >= target - numbers(i))
      if (j < i && numbers(i) + numbers(j) == target) {
        Array(j + 1, i + 1)
      } else {
        go(i - 1)
      }
    }

    go(numbers.length - 1)
  }

  private def binarySearch(n: Int, fn: Int => Boolean): Int = {
    var left = 0
    var right = n
    while (left < right) {
      val mid = (left + right) / 2
      if (fn(mid)) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    left
  }

}
