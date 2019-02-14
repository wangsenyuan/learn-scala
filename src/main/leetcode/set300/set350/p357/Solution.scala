package set300.set350.p357

object Solution {
  def countNumbersWithUniqueDigits(n: Int): Int = {
    if (n == 0) {
      1
    } else if (n == 1) {
      10
    } else if (n == 2) {
      91
    } else {
      val dp = Array.ofDim[Int](n + 1)
      dp(0) = 1
      dp(1) = 10
      dp(2) = 91
      var i = 3
      var num = 9 * 9
      while (i <= n) {
        num *= (0 max (11 - i))
        dp(i) = dp(i - 1) + num
        i += 1
      }
      dp(n)
    }
  }
}
