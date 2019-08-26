package set0000.set000.set050.p053

object Solution {

  def maxSubArray(nums: Array[Int]): Int = {
    if (nums.size == 0) {
      0
    } else {
      nums.foldLeft((Int.MinValue, 0))((ans, num) => {
        val (best, sum) = ans
        val newSum = sum + num
        val newBest = best max newSum
        (newBest, newSum max 0)
      })._1
    }
  }

  def maxSubArray1(nums: Array[Int]): Int = {
    if (nums.size == 0) {
      0
    } else {
      var best = Int.MinValue
      var sum = 0
      var i = 0
      while (i < nums.size) {
        sum += nums(i)
        best = best max sum
        if (sum < 0) {
          sum = 0
        }
        i += 1
      }
      best
    }
  }
}

