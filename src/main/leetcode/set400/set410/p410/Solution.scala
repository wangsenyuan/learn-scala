package set400.set410.p410

import scala.language.postfixOps

object Solution {
  def splitArray(nums: Array[Int], m: Int): Int = {
    val n = nums.length

    def check(cap: Long): Boolean = {
      var sum = 0L
      var i = 0
      var cnt = 1
      while (i < n && cnt <= m && sum <= cap) {
        sum += nums(i)
        if (sum > cap) {
          sum = nums(i)
          cnt += 1
        }
        i += 1
      }

      cnt <= m && sum <= cap
    }

    var left = 0L
    var right = Int.MaxValue.toLong + 1
    while (left < right) {
      val mid = (left + right) / 2
      if (check(mid)) {
        right = mid
      } else {
        left = mid + 1
      }
    }
    right.toInt
  }

  def splitArray1(nums: Array[Int], m: Int): Int = {
    val n = nums.length

    val dp = Array.fill(n + 1, m + 1)(Long.MaxValue)
    dp(0)(0) = 0

    for {
      i <- 0 until n
      j <- 1 to m
    } {
      // cal dp(i)(j)
      var sum = 0L
      var k = i
      while (k >= 0) {
        sum += nums(k)
        dp(i + 1)(j) = dp(i + 1)(j) min (sum max dp(k)(j - 1))
        k -= 1
      }
    }

    (dp(n) min).toInt
  }
}
