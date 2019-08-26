package set0000.set300.set390.p392

object Solution {
  def isSubsequence(s: String, t: String): Boolean = {
    var j = -1
    var can = true
    var i = 0
    while(i < s.length && can) {
      j += 1
      while(j < t.length && s(i) != t(j)) {
        j += 1
      }
      can = j < t.length
      i += 1
    }

    can
  }

  def isSubsequence1(s: String, t: String): Boolean = {
    val m = s.length
    val n = t.length
    val dp = Array.fill(n + 1)(true)

    var i = 0
    while (i < m && dp(n)) {
      //t at least as long as s
      var can = false
      var j = i
      while (j < n && !can) {
        can = s(i) == t(j) && dp(j)
        j += 1
      }

      var k = i
      while (k <= n) {
        dp(k) = k >= j && can
        k += 1
      }

      i += 1
    }

    dp(n)
  }
}
