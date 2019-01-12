package set200.set210.p214

object Solution {

  def prepare(s: String): String = {
    val n = s.length
    val t = "#" * n
    (t.zip(s).flatMap(x => "" + x._1 + "" + x._2)).mkString("") + "#"
  }

  def shortestPalindrome(s: String): String = {
    val t = prepare(s)
    val n = t.length
    val p = Array.fill(n)(0)
    var center = 0
    var right = -1
    var at = 0
    var i = 0
    while (i < n) {
      val j = 2 * center - i
      if (right >= i) {
        p(i) = (right - i) min p(j)
      }
      while (i - p(i) >= 0 && i + p(i) < n && t(i + p(i)) == t(i - p(i))) {
        p(i) += 1
      }
      if (i + p(i) > right) {
        center = i
        right = i + p(i) - 1
      }

      if (p(i) == i + 1) {
        at = right
      }

      i += 1
    }

    at /= 2

    val prefix = s.substring(at).reverse

    prefix + s
  }
}
