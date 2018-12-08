package set000.set040.p045

object Solution {
  def jump(nums: Array[Int]): Int = {
    val n = nums.length
    val dp = Array.fill(n)(Int.MaxValue)
    dp(0) = 0
    var i = 0
    while (i < n) {
      val num = nums(i)
      var j = 1
      while (j <= num && i + j < n) {
        dp(i + j) = dp(i + j) min (dp(i) + 1)
        j += 1
      }

      i += 1
    }
    dp(n - 1)
  }
}
