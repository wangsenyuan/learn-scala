package set0000.set900.set980.p986


import scala.collection.mutable.ArrayBuffer

object Solution {
  def intervalIntersection(A: Array[Array[Int]], B: Array[Array[Int]]): Array[Array[Int]] = {
    val buf = ArrayBuffer.empty[Array[Int]]
    var i = 0
    var j = 0
    while (i < A.length && j < B.length) {
      val x = A(i)(0) max B(j)(0)
      if (A(i)(1) <= B(j)(1)) {

        if (x <= A(i)(1)) {
          buf += Array(x, A(i)(1))
        }
        i += 1
      } else {
        if (x <= B(j)(1)) {
          buf += Array(x, B(j)(1))
        }
        j += 1
      }
    }
    buf.toArray
  }
}
