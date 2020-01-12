package set1000.set1300.set1310.p1316

object Solution {
  def distinctEchoSubstrings(text: String): Int = {
    val n = text.length
    val dp = Array.ofDim[Long](n, n)

    val MOD = 1000000000007L
    val P = 31

    var i = 0
    while (i < n) {
      var hash = 0L
      var j = i
      while (j < n) {
        hash = hash * P + (text.charAt(j) - 'a' + 1)
        hash %= MOD
        dp(i)(j) = hash
        j += 1
      }
      i += 1
    }
    var res = Set.empty[Long]
    i = 0
    while (i < n) {
      var j = i + 1
      while (j < n) {
        val k = (j - i) / 2 + i
        if (dp(i)(k) == dp(k + 1)(j)) {
          res += dp(i)(j)
        }
        j += 2
      }
      i += 1
    }

    res.size
  }
}
