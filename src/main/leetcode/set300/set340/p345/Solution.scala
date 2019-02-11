package set300.set340.p345

object Solution {
  def reverseVowels(s: String): String = {
    val cs = s.toCharArray()

    var i = 0
    var j = cs.length - 1

    while (i < j) {
      if (isVowel(cs(i))) {
        while (j > i && !isVowel(cs(j))) {
          j -= 1
        }
        if (i < j) {
          val c = cs(i)
          cs(i) = cs(j)
          cs(j) = c
        }
        //        i += 1
        j -= 1
      }

      i += 1
    }

    new String(cs)
  }

  private def isVowel(c: Char) = {
    c == 'a' || c == 'o' || c == 'e' || c == 'i' || c == 'u' ||
      c == 'A' || c == 'O' || c == 'E' || c == 'I' || c == 'U'
  }
}
