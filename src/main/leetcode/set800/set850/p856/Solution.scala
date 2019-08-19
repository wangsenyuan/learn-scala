package set800.set850.p856

object Solution {
  def scoreOfParentheses(S: String): Int = {
    val n = S.length

    var res = 0
    var i = 0
    var cur = 1
    var level = 1
    while (i < n) {
      if (S(i) == '(') {
        level += 1

        if (S(i + 1) == ')') {
          res += cur
        }

        cur <<= 1
      } else {
        level -= 1
        cur >>= 1
      }
      i += 1
    }

    res
  }
}
