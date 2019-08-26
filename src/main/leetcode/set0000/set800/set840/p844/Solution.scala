package set0000.set800.set840.p844

object Solution {

  def backspaceCompare(S: String, T: String): Boolean = {
    var i = S.length - 1
    var j = T.length - 1
    var skipS = 0
    var skipT = 0
    while (i >= 0 || j >= 0) {
      while (i >= 0 && (skipS > 0 || S(i) == '#')) {
        if (S(i) == '#') {
          skipS += 1
          i -= 1
        } else if (skipS > 0) {
          skipS -= 1
          i -= 1
        }
      }
      while (j >= 0 && (skipT > 0 || T(j) == '#')) {
        if (T(j) == '#') {
          skipT += 1
          j -= 1
        } else if (skipT > 0) {
          skipT -= 1
          j -= 1
        }
      }

      if (i >= 0 && j >= 0 && S(i) != T(j)) {
        return false
      }

      if (i >= 0 != j >= 0) {
        return false
      }
      i -= 1
      j -= 1
    }
    true
  }

  def backspaceCompare1(S: String, T: String): Boolean = {
    normalize(S) == normalize(T)
  }

  private def normalize(str: String): String = {
    val buf = new StringBuilder
    var i = 0
    while (i < str.length) {
      if (str(i) == '#') {
        if (buf.length > 0) {
          buf.setLength(buf.length - 1)
        }
      } else {
        buf.append(str(i))
      }
      i += 1
    }
    buf.toString()
  }
}
