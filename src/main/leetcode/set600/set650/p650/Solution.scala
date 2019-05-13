package set600.set650.p650

object Solution {
  def minSteps(n: Int): Int = {
    val dp = Array.fill(n + 1)(Int.MaxValue)
    dp(1) = 0

    var i = 1
    while(i < n) {
      var j = 2 * i
      while(j <= n) {
        dp(j) = dp(j) min (dp(i) + (j / i))
        j += i
      }

      i += 1
    }

    dp(n)
  }
}
