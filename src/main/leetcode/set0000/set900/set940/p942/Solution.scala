package set0000.set900.set940.p942

import scala.collection.mutable.ArrayBuffer

object Solution {
  def diStringMatch(S: String): Array[Int] = {
    val buf = ArrayBuffer.empty[Int]

    val n = S.length
    var x = 0
    var y = n

    var i = 0
    while (i < n) {
      if (S(i) == 'D') {
        buf += y
        y -= 1
      } else {
        buf += x
        x += 1
      }
      i += 1
    }

    if (x == y) {
      buf += x
    }

    buf.toArray
  }
}
