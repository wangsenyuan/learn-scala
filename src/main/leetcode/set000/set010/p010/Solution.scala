package set000.set010.p010

object Solution {
  def isMatch(s: String, p: String): Boolean = {

    def go(i: Int, j: Int): Boolean = {
      if (i == s.length && j == p.length) {
        true
      } else if (j == p.length) {
        false
      } else {
        p(j) match {
          case c if j < p.length - 1 && p(j + 1) == '*' =>
            // c*
            // c repeat 0 time
            var found = go(i, j + 2)
            if (!found && i < s.length && canPair(s(i), c)) {
              var k = i
              while (k < s.length && !found && canPair(s(k), c)) {
                found = go(k + 1, j + 2)
                k += 1
              }
            }
            found
          case c if i < s.length && canPair(s(i), c) => go(i + 1, j + 1)
          case _ => false
        }
      }
    }

    go(0, 0)
  }

  private def canPair(a: Char, b: Char) = {
    if (a == b) {
      true
    } else if (b == '.') {
      true
    } else {
      false
    }
  }

}
