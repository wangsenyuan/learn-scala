package set0000.set400.set460.p464

object Solution {
  def canIWin(maxChoosableInteger: Int, desiredTotal: Int): Boolean = {

    val N = 1 << maxChoosableInteger
    val dp = Array.fill(N)(0)
    val total = (1 + maxChoosableInteger) * maxChoosableInteger / 2

    def go(mask: Int, sum: Int): Boolean = {
      if (sum >= desiredTotal) {
        false
      } else if (dp(mask) != 0) {
        dp(mask) > 0
      } else {
        var win = false
        var x = 1
        while (x <= maxChoosableInteger && !win) {
          if ((mask & (1 << (x - 1))) == 0) {
            win = !go(mask | (1 << (x - 1)), sum + x)
          }

          x += 1
        }
        dp(mask) =
          if (win) {
            1
          } else {
            -1
          }
        win
      }
    }

    total >= desiredTotal && (desiredTotal == 0 || go(0, 0))
  }
}
