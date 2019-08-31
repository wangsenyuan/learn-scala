package set0000.set800.set880.p885

import scala.collection.mutable.ArrayBuffer

object Solution {
  def spiralMatrixIII(R: Int, C: Int, r0: Int, c0: Int): Array[Array[Int]] = {
    var x = r0
    var y = c0
    var steps = 1
    // 0 for east, 1 for south, 2 for west, 3 for north
    var d = 0

    val N = R * C
    val buf = ArrayBuffer.empty[Array[Int]]

    while (buf.size < N) {
      var i = 0
      while (i < steps) {
        if (x >= 0 && x < R && y >= 0 && y < C) {
          buf += Array(x, y)
        }

        if (d == 0) {
          y += 1
        } else if (d == 1) {
          x += 1
        } else if (d == 2) {
          y -= 1
        } else {
          x -= 1
        }
        i += 1
      }

      d = (d + 1) % 4
      if (d == 2 || d == 0) {
        // when change to east or west
        steps += 1
      }
    }

    buf.toArray
  }
}
