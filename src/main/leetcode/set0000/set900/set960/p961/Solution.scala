package set0000.set900.set960.p961

object Solution {
  def repeatedNTimes(A: Array[Int]): Int = {
    val n = A.length
    if (n == 2) {
      A(0)
    } else {
      var i = 0
      while (i < n - 1) {
        if (A(i) == A(i + 1)) {
          return A(i)
        }
        if (i > 0 && A(i - 1) == A(i + 1)) {
          return A(i - 1)
        }
        i += 1
      }
      // only 3 1 2 3 volates this
      A(n - 1)
    }
  }
}
