package validpalindrome

/**
 * Created by senyuanwang on 15/3/16.
 */
object App extends App {

  def isAlpha(c: Char): Boolean = (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')

  def isNumeric(c: Char): Boolean = c >= '0' && c <= '9'

  def isNotValid(c: Char): Boolean = !isAlpha(c) && !isNumeric(c)

  def isEqual(a: Char, b: Char) = a.toLower == b.toLower

  def checkStr(str: String): Boolean = {

    def doCheck(chars: Array[Char], i: Int, j: Int): Boolean =
      if (i >= j) true
      else {
        val x = chars(i)
        val y = chars(j)

        if (isNotValid(x)) {
          doCheck(chars, i + 1, j)
        } else if (isNotValid(y)) {
          doCheck(chars, i, j - 1)
        } else if (!isEqual(x, y)) {
          false
        } else {
          doCheck(chars, i + 1, j - 1)
        }
      }

    val chars = str.toCharArray
    doCheck(chars, 0, chars.length - 1)
  }

  println(checkStr("A man, a plan, a canal: Panama"))
}
