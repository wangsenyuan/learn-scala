package set0000.set900.set970.p977

import scala.collection.mutable.ArrayBuffer

object Solution {
  def sortedSquares(A: Array[Int]): Array[Int] = {
    val n = A.length
    if (n == 0) {
      Array()
    } else {
      var i = 0
      while (i < n && A(i) < 0) {
        i += 1
      }

      // A(i) >= 0
      var j = i - 1
      val buf = ArrayBuffer.empty[Int]

      while (i < n && j >= 0) {
        val x = A(i) * A(i)
        val y = A(j) * A(j)
        if (x <= y) {
          buf += x
          i += 1
        } else {
          buf += y
          j -= 1
        }
      }

      while (i < n) {
        buf += A(i) * A(i)
        i += 1
      }
      while (j >= 0) {
        buf += A(j) * A(j)
        j -= 1
      }

      buf.toArray
    }
  }
}
