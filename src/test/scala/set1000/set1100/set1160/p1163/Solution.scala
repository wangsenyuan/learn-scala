package set1000.set1100.set1160.p1163

object Solution {
  def lastSubstring(s: String): String = {
    val n = s.length
    var i = 0
    var j = 1
    var offset = 0
    while (i + offset < n && j + offset < n) {
      val a = s(i + offset)
      val b = s(j + offset)
      if (a == b) {
        offset += 1
      } else {
        if (a < b) {
          i += offset + 1
        } else {
          j += offset + 1
        }
        if (i == j) {
          i += 1
        }
        offset = 0
      }
    }
    s.substring(i min j)
  }
}
