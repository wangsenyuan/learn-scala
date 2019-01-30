package set200.set290.p290

object Solution {
  def wordPattern(pattern: String, str: String): Boolean = {
    val m = pattern.length
    if (m == 0) {
      str.length == 0
    } else {
      val ss = str.split(" ")
      if (ss.length != m) {
        false
      } else {
        val x = pattern.zip(ss).toMap
        val y = ss.zip(pattern).toMap
        x.size == y.size && (x.map(x => x._2 -> x._1)).equals(y)
      }
    }
  }
}
