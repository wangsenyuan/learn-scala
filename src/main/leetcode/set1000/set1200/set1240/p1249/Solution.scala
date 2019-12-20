package set1000.set1200.set1240.p1249

object Solution {
  def minRemoveToMakeValid(s: String): String = {
    val buf = new StringBuilder
    var level = 0
    var i = 0
    while (i < s.length) {
      if (s(i) == '(' || s(i) == ')') {
        if (s(i) == '(') {
          level += 1
        } else {
          level -= 1
        }
        if (level >= 0) {
          buf.append(s(i))
        } else {
          level = 0
        }
      } else {
        buf.append(s(i))
      }

      i += 1
    }

    i = buf.length() - 1
    while (i >= 0 && level > 0) {
      if (buf.charAt(i) == '(') {
        buf.deleteCharAt(i)
        level -= 1
      }
      i -= 1
    }
    buf.toString()
  }
}
