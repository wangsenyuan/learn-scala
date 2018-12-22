package set000.set090.p093

import scala.collection.mutable.ListBuffer

object Solution {
  def restoreIpAddresses(s: String): List[String] = {
    val ans = ListBuffer.empty[String]

    def go(i: Int, s: String, res: String): Unit = {
      if (i == 4) {
        if (s.isEmpty) {
          ans += res.tail
        }
      } else if (!s.isEmpty) {
        var j = 1
        while (j < 4 && j <= s.length) {
          val x = s.substring(0, j)
          if (valid(x)) {
            go(i + 1, s.substring(j), res + "." + x)
          }
          j += 1
        }
      }
    }

    go(0, s, "")

    ans.toList
  }

  private def valid(s: String): Boolean = {
    if (s.length == 1) {
      true
    } else if (s.length == 2 && s(0) > '0') {
      true
    } else {
      //s.length == 3
      s(0) > '0' && s.toInt < 256
    }
  }
}
