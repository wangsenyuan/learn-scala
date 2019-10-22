package set1000.set1000.set1000.p1007

object Solution {
  def minDominoRotations(A: Array[Int], B: Array[Int]): Int = {
    val a = rotate(A, B) min rotate(B, A)
    A(0) = A(0) ^ B(0)
    B(0) = A(0) ^ B(0)
    A(0) = A(0) ^ B(0)

    var b = rotate(A, B) min rotate(B, A)

    if (b < Int.MaxValue) {
      b += 1
    }

    val ans = a min b

    if (ans == Int.MaxValue) {
      -1
    } else {
      ans
    }
  }

  private def rotate(A: Array[Int], B: Array[Int]): Int = {
    var res = 0
    val x = A(0)
    var i = 1
    while (i < A.length && res < Int.MaxValue) {
      if (A(i) != x) {
        if (B(i) == x) {
          res += 1
        } else {
          res = Int.MaxValue
        }
      }
      i += 1
    }

    res
  }
}
