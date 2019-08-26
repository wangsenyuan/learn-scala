package set0000.set600.set670.p673

object Solution {
  def findNumberOfLIS(nums: Array[Int]): Int = {
    val n = nums.length
    if(n == 0) {
      0
    } else {
      val dp = Array.ofDim[Int](n)
      val fp = Array.ofDim[Int](n)
      dp(0) = 1
      fp(0) = 1
      var best = 1
      var res = 1
      var i = 1
      while (i < n) {
        dp(i) = 1
        fp(i) = 1
        var j = 0
        while(j < i) {
          if(nums(j) < nums(i)) {
            if(dp(i) < dp(j) + 1) {
              dp(i) = dp(j) + 1
              fp(i) = fp(j)
            } else if (dp(i) == dp(j) + 1) {
              fp(i) += fp(j)
            }
          }
          j += 1
        }

        if(dp(i) > best) {
          best = dp(i)
          res = fp(i)
        } else if(dp(i) == best) {
          res += fp(i)
        }

        i += 1
      }

      res
    }
  }

}
