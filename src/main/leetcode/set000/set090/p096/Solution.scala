package set000.set090.p096

object Solution {
  def numTrees(n: Int): Int = {
    if (n == 0) {
      1
    } else {
      val dp = Array.fill(n + 1)(0)
      dp(0) = 1
      dp(1) = 1

      var i = 2
      while (i <= n) {
        // take any one between 1 to i as root
        var j = 1
        while (j <= i) {
          dp(i) += dp(j - 1) * dp(i - j)
          j += 1
        }
        i += 1
      }

      dp(n)
    }
  }
}
