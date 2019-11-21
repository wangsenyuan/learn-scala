package set1000.set1100.set1130.p1138

import scala.collection.mutable.ArrayBuffer

object Solution {
  def alphabetBoardPath(target: String): String = {
    val buf = ArrayBuffer.empty[String]

    var x = 0
    var y = 0

    var i = 0
    while (i < target.length) {
      val (a, b) = getPosition(target.charAt(i))
      if (x != a || y != b) {
        if (x > a) {
          buf += "U" * (x - a)
          x = a
        }
        if (y > b) {
          buf += "L" * (y - b)
          y = b
        } else if (y < b) {
          buf += "R" * (b - y)
          y = b
        }

        if (x < a) {
          buf += "D" * (a - x)
          x = a
        }
      }
      buf += "!"
      i += 1
    }

    buf.mkString("")
  }

  private def getPosition(c: Char): (Int, Int) = {
    val d = c - 'a'
    (d / 5, d % 5)
  }
}
