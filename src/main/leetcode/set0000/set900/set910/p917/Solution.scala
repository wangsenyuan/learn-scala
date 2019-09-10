package set0000.set900.set910.p917

object Solution {
  def reverseOnlyLetters(S: String): String = {
    val arr = S.toCharArray

    var i = 0
    var j = arr.length - 1
    while (i < j) {
      while (i < j && !isLetter(arr(i))) {
        i += 1
      }

      while (i < j && !isLetter(arr(j))) {
        j -= 1
      }
      if (i < j) {
        val x = arr(i)
        arr(i) = arr(j)
        arr(j) = x
        i += 1
        j -= 1
      }
    }
    arr.mkString("")
  }

  private def isLetter(c: Char): Boolean = (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')
}
