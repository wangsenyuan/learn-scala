package set0000.set000.set080.p087

import scala.collection.mutable

object Solution {
  def isScramble(s1: String, s2: String): Boolean = {
    val mem = mutable.Map.empty[String, Boolean]

    def go(a: String, b: String): Boolean = {
      if (a == b) {
        true
      } else if (a.length != b.length) {
        false
      } else if (mem.contains(a + "|" + b)) {
        mem(a + "|" + b)
      } else {
        val n = a.length
        if (n == 1) {
          return false
        } else {
          var i = 1
          var ok = false
          while (i < n && !ok) {
            ok = (go(a.substring(0, i), b.substring(0, i)) && go(a.substring(i), b.substring(i))) ||
              (go(a.substring(0, i), b.substring(n - i)) && go(a.substring(i), b.substring(0, n - i)))
            i += 1
          }
          mem(a + "|" + b) = ok
          ok
        }
      }
    }

    go(s1, s2)
  }
}
