package set1000.set1200.set1280.p1283

object Solution {
  def smallestDivisor(nums: Array[Int], threshold: Int): Int = {
    def check(num: Int): Boolean = {
      val sum = nums.map(x => divide(x, num)).sum
      sum <= threshold
    }

    var left = 1
    var right = 10000000

    while (left < right) {
      val mid = (left + right) / 2
      if (check(mid)) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    right
  }

  private def divide(a: Int, b: Int): Int = {
    val c = a / b
    if (c * b == a) {
      c
    } else {
      c + 1
    }
  }
}
