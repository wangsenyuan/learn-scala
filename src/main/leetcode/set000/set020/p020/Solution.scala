package set000.set020.p020

object Solution {
  def isValid(s: String): Boolean = {
    val n = s.length
    if (n == 0) {
      true
    } else {
      val stack = Array.fill(n)(0)
      var i = 0
      var p = 0
      while (i < n) {
        val c = s(i)
        if (isLeft(c)) {
          stack(p) = i
          p += 1
        } else if (p == 0 || !canPair(s(stack(p - 1)), c)) {
          i = n
        } else {
          p -= 1
        }
        i += 1
      }
      p == 0 && i == n
    }
  }

  private def isLeft(c: Char) = c == '(' || c == '{' || c == '['

  private def canPair(a: Char, b: Char) = {
    if (a == '(' && b == ')') {
      true
    } else if (a == '[' && b == ']') {
      true
    } else if (a == '{' && b == '}') {
      true
    } else {
      false
    }
  }
}
