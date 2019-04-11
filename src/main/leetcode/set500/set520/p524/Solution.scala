package set500.set520.p524

object Solution {
  def findLongestWord(s: String, d: List[String]): String = {
    val words = d.filter(word => contains(s, word))
    if(words.isEmpty) {
      ""
    } else {
      val lg = words.map(_.length).max
      val ws = words.filter(_.length == lg).sorted
      ws.head
    }
  }

  private def contains(a: String, b: String): Boolean = {
    var i = 0
    var j = 0
    while(j < b.length) {
      while(i < a.length && a(i) != b(j)) {
        i += 1
      }
      if(i == a.length) {
        return false
      }
      i += 1
      j += 1
    }
    return true
  }
}
