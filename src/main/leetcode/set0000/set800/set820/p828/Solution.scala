package set0000.set800.set820.p828

object Solution {
  val MOD = 1000000007L

  def uniqueLetterString(S: String): Int = {
    val n = S.length

    var res = 0L

    ('A' to 'Z').foreach(c => {
      res += count(c, S)
      if (res >= MOD) {
        res -= MOD
      }
    })

    res.toInt
  }

  private def count(c: Char, s: String): Long = {
    val n = s.length

    var i = 0
    while (i < n && s(i) != c) {
      i += 1
    }

    if (i == n) {
      // c not found
      0
    } else {
      var res = 0L
      var a = -1
      var b = i
      i += 1
      while (i <= n) {
        if (i == n || s(i) == c) {
          val x = (b - a).toLong
          val y = (i - b).toLong
          res += x * y
          res %= MOD
          a = b
          b = i
        }

        i += 1
      }

      res
    }
  }
}
