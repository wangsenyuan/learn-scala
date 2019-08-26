package set0000.set000.set060.p062

object Solution {

  def uniquePaths(m: Int, n: Int): Int = {
    val dp = Array.fill(m, n)(0)
    dp(0)(0) = 1

    var i = 0
    while(i < m) {
      var j = 0
      while(j < n) {
        if (i + 1 < m) {
          dp(i + 1)(j) += dp(i)(j)
        }
        if (j + 1 < n) {
          dp(i)(j + 1) += dp(i)(j)
        }
        j += 1
      }
      i += 1
    }

    dp(m - 1)(n - 1)
  }
}
