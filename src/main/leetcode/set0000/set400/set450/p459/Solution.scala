package set0000.set400.set450.p459

object Solution {
  def repeatedSubstringPattern(s: String): Boolean = {
    val n = s.length

    def check(k: Int): Boolean = {
      var i = k
      var can = true
      while (i + k <= n && can) {
        var j = 0
        while (j < k && s(j) == s(i + j)) {
          j += 1
        }
        can = j == k
        i += k
      }
      can
    }

    val set = Array.ofDim[Boolean](n + 1)

    var can = false
    var h = 2

    while(h <= n && !can) {
      if(!set(h)) {
        can = n % h == 0 && check(n / h)
        var hh = h * h
        while(hh <= n) {
          set(hh) = true
          hh += h
        }
      }
      h += 1
    }

    can
  }
}
