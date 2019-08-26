package set0000.set400.set490.p494

object Solution {
  def findTargetSumWays(nums: Array[Int], S: Int): Int = {
    val n = nums.length
    val N = 1 << n

    var res = 0
    for {
      mask <- 0 until N
    } {
      var sum = 0L
      var i = n - 1
      while (i >= 0) {
        if ((mask & (1 << i)) == 0) {
          sum += nums(i)
        } else {
          sum -= nums(i)
        }
        i -= 1
      }
      if (sum == S) {
        res += 1
      }
    }
    res
  }
}
