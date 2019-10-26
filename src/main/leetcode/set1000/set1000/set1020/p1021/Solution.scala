package set1000.set1000.set1020.p1021

import scala.collection.mutable.ArrayBuffer

object Solution {
  def removeOuterParentheses(S: String): String = {
    val buf = ArrayBuffer.empty[Char]
    var level = 0
    var i = 0
    while (i < S.length) {
      if (S(i) == '(') {
        level += 1
        if (level > 1) {
          buf += S(i)
        }
      } else {
        level -= 1
        if (level > 0) {
          buf += S(i)
        }
      }
      i += 1
    }

    buf.mkString("")
  }
}
