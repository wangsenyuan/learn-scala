package set000.set000.p005

object Solution {
  def longestPalindrome(s: String): String = {
    val ss = prepare(s)
    val n = ss.length
    val p = Array.fill(n)(0)
    var i = 1
    var center = 0
    var right = 0
    while (i < n - 1) {
      val j = 2 * center - i
      if (right > i) {
        p(i) = p(j) min (right - i)
      }

      while (ss(i + 1 + p(i)) == ss(i - 1 - p(i))) {
        p(i) += 1
      }

      if (i + p(i) > right) {
        center = i
        right = i + p(i)
      }
      i += 1
    }

    val xx = p.zipWithIndex.maxBy(_._1)
    val (len, pos) = xx
    val start = (pos - 1 - len) / 2

    s.substring(start, start + len)
  }

  def prepare(s: String): String = {
    val n = s.length
    val t = "#" * n
    val r = t.zip(s).flatMap(x => "" + x._1 + x._2).mkString
    "^" + r + "#$"
  }

  def longestPalindrome1(s: String): String = {

    def expend(x: Int, y: Int): (Int, Int) = {
      var i = x
      var j = y
      while (i >= 0 && j < s.length && s(i) == s(j)) {
        i -= 1
        j += 1
      }
      i += 1
      j -= 1
      (i, j)
    }

    def expandOdd(pos: Int): (Int, Int) = {
      expend(pos - 1, pos + 1)
    }

    def expenseEven(pos: Int): (Int, Int) = {
      expend(pos, pos + 1)
    }


    def findPalindrome(res: String, cur: (Char, Int)): String = {
      val (a, b) = expandOdd(cur._2)
      var ans = res
      if (b - a + 1 > length(ans)) {
        ans = s.substring(a, b + 1)
      }
      val (c, d) = expenseEven(cur._2)
      if (d - c + 1 > length(ans)) {
        ans = s.substring(c, d + 1)
      }
      ans
    }

    s.zipWithIndex.foldLeft("")(findPalindrome)
  }

  private def length(str: String): Int = {
    if (str == null) {
      0
    } else {
      str.length
    }
  }
}
