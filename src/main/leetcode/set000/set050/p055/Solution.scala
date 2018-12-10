package set000.set050.p055

object Solution {

  def canJump(nums: Array[Int]): Boolean = {
    val n = nums.length
    if (n <= 1) {
      true
    } else {
      val dp = Array.fill(n)(false)

      def jump(i: Int): Boolean = {
        if (i == n - 1) {
          dp(n - 1)
        } else if (dp(i)) {
          for {
            j <- i + 1 until (n min (i + nums(i) + 1))
          } {
            dp(j) = true
          }
          jump(i + 1)
        } else {
          false
        }
      }

      dp(0) = true

      jump(0)
    }

  }

  def canJump1(nums: Array[Int]): Boolean = {
    val n = nums.length
    if (n <= 1) {
      true
    } else {
      val dp = Array.fill(n)(false)
      dp(0) = true
      var i = 0
      while (i < n) {
        if (dp(i)) {
          var j = i + 1
          while (j < n && j <= i + nums(i)) {
            dp(j) = true
            j += 1
          }
        }
        i += 1
      }
      dp(n - 1)
    }

  }
}
