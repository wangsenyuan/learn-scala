package set1000.set1000.set1070.p1071

object Solution {
  def gcdOfStrings(str1: String, str2: String): String = {

    def gcd(a: String, b: String): String = {
      // a, b = b, a % b
      if (b.isEmpty) {
        a
      } else {
        // a = n * b + r
        // where b starts with r
        if (canDivide(a, b)) {
          val r = a.length % b.length
          gcd(b, a.substring(0, r))
        } else {
          ""
        }
      }
    }

    gcd(str1, str2)
  }

  private def canDivide(a: String, b: String): Boolean = {
    var can = true
    var j = 0
    while (j < b.length && can) {
      var i = j
      while (i < a.length && can) {
        can = a(i) == b(j)
        i += b.length
      }

      j += 1
    }

    can
  }
}
