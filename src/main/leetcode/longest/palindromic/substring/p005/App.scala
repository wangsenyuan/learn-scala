package longest.palindromic.substring.p005

/**
 * Created by senyuanwang on 15/3/29.
 *
 * http://en.wikipedia.org/wiki/Longest_palindromic_substring
 */
object App extends App {

  def longestPalindrome(s: String): String = {

    def addBounderies(cs: Array[Char]): Array[Char] = {
      val n = cs.length
      val ncs = Array.fill(2 * n + 1)('|')

      for (i <- 0 until ncs.length - 1 by 2) {
        ncs(i + 1) = cs(i / 2)
      }
      ncs
    }

    val cs = addBounderies(s.toCharArray)

    val p = Array.fill(cs.length)(0)

    def findPalindromicLen(m: Int, n: Int, d: Int): Int = {
      if (m < 0 || n >= cs.length || cs(m) != cs(n)) d
      else findPalindromicLen(m - 1, n + 1, d + 1)
    }

    def go(i: Int, c: Int, r: Int, m: Int, n: Int): Unit =
      if (i < cs.length) {
        val j = 2 * c - i
        if (i > r) {
          p(i) = 0
        } else if (p(j) < r - i) {
          p(i) = p(j)
        } else {
          p(i) = r - i
        }

        val (ma, na) =
          if (i > r) (i - 1, i + 1)
          else if (p(j) < r - i) {
            (-1, n)
          } else {
            val nb = r + 1
            (2 * i - nb, nb)
          }

        p(i) = findPalindromicLen(ma, na, p(i))

        if (i + p(i) > r) {
          go(i + 1, i, i + p(i), ma, na)
        } else {
          go(i + 1, c, r, ma, na)
        }
      }

    go(0, 0, 0, 0, 0)

    def longest(i: Int, c: Int): (Int, Int) =
      if (i >= p.length) (c, p(c))
      else {
        if (p(i) > p(c)) {
          longest(i + 1, i)
        } else {
          longest(i + 1, c)
        }
      }

    val (c, pc) = longest(1, 0)

    val xs = for (i <- c - pc to c + pc) yield cs(i)
    xs.filterNot(_ == '|').mkString("")
  }

  println(longestPalindrome("babcbabcbaccba"))

  println(longestPalindrome("abaaba"))

  println(longestPalindrome("abababa"))

  println(longestPalindrome("abcbabcbabcba"))

  println(longestPalindrome("forgeeksskeegfor"))

  println(longestPalindrome("caba"))

  println(longestPalindrome("abacdfgdcabba"))

  println(longestPalindrome("abacdedcaba"))
}
