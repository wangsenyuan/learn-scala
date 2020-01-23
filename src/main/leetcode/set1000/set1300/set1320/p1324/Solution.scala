package set1000.set1300.set1320.p1324

import scala.collection.mutable.ListBuffer

object Solution {
  def printVertically(s: String): List[String] = {
    val words = s.split("\\s+")
    val res = ListBuffer.empty[String]

    val width = words.maxBy(_.length).length

    val buf = new StringBuilder

    var j = 0
    while (j < width) {
      buf.clear()

      var i = 0
      while (i < words.length) {
        if (j >= words(i).length) {
          buf += ' '
        } else {
          buf += words(i)(j)
        }
        i += 1
      }

      i = words.length - 1
      while (buf(i) == ' ') {
        i -= 1
      }

      res += buf.take(i + 1).toString()

      j += 1
    }

    res.toList
  }
}
