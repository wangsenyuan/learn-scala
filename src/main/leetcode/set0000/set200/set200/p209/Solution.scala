package set0000.set200.set200.p209

object Solution {
  def minSubArrayLen(s: Int, nums: Array[Int]): Int = {
    val n = nums.length
    val sums = Array.fill(n + 1)(0)
    // sums(i) - sums(j) >= s => sums(i) - s >= sums(j) => right-most index before i, that satisfy the condition
    var i = 0
    while (i < n) {
      sums(i + 1) = sums(i) + nums(i)
      i += 1
    }
    var ans = Int.MaxValue

    i = n - 1
    while (i >= 0) {
      val j = binarySearch(i + 1, n + 1, sums(_) - sums(i) >= s)
      if (j < n + 1) {
        ans = ans min (j - i)
      }
      i -= 1
    }

    if (ans < Int.MaxValue) {
      ans
    } else {
      0
    }
  }

  private def binarySearch(start: Int, end: Int, fn: Int => Boolean): Int = {
    var left = start
    var right = end
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


  def minSubArrayLen1(s: Int, nums: Array[Int]): Int = {
    var sum = 0
    val n = nums.length
    var ans = Int.MaxValue
    var j = 0
    var i = 0
    while (i < n) {
      sum += nums(i)

      while (sum - nums(j) >= s) {
        sum -= nums(j)
        j += 1
      }
      if (sum >= s) {
        ans = ans min (i - j + 1)
      }

      i += 1
    }
    if (ans < Int.MaxValue) {
      ans
    } else {
      0
    }
  }
}
