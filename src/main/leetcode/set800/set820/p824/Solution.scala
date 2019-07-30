package set800.set820.p824

object Solution {
  def toGoatLatin(S: String): String = {
    val ss = S.split(" ")
    val buf = new StringBuilder()

    var i = 0
    while(i < ss.length) {
      val s = ss(i)
      if(startsWithVowel(s)) {
        buf.append(s)
        buf.append("ma")
      } else {
        buf.append(s.tail)
        buf.append(s.head)
        buf.append("ma")
      }
      buf.append("a" * (i + 1))
      if(i < ss.length - 1) {
        buf.append(" ")
      }
      i += 1
    }

    buf.toString()
  }

  private def startsWithVowel(str: String) = {
    val h = str.head.toLower
    h == 'a' || h == 'o' || h == 'e' || h == 'i' || h == 'u'
  }
}
