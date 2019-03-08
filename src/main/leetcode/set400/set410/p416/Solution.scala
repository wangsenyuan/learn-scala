package set400.set410.p416

object Solution {
  def canPartition(nums: Array[Int]): Boolean = {
    val sum = nums.sum
    if (sum % 2 == 1) {
      false
    } else {
      val half = sum >> 1
      val dp = Array.ofDim[Int](half + 1)
      dp(0) = 1

      nums.foreach(num => {
        if (num <= half) {
          for {
            i <- half until num by -1
          } {
            dp(i) += dp(i - num)
          }
          dp(num) += 1
        }
      })

      dp(half) != 0
    }
  }
}
