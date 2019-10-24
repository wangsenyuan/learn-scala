package set1000.set1000.set1010.p1013

object Solution {
  def canThreePartsEqualSum(A: Array[Int]): Boolean = {
    val sum = A.sum

    if (sum % 3 != 0) {
      false
    } else {
      val x = sum / 3
      var y = 0
      var i = 0
      while (i < A.length && y != x) {
        y += A(i)
        i += 1
      }
      if (i == A.length) {
        false
      } else {
        var z = 0
        while (i < A.length && z != x) {
          z += A(i)
          i += 1
        }
        i < A.length
      }
    }
  }
}
