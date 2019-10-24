package set1000.set1000.set1010.p1017

import scala.collection.mutable.ArrayBuffer

object Solution {
  def baseNeg2(N: Int): String = {
    if (N == 0) {
      "0"
    } else {
      val buf = ArrayBuffer.empty[Int]

      var num = N

      while (num != 0) {
        buf += num & 1
        num = -(num >> 1)
      }

      buf.reverse.mkString("")
    }
  }
}
