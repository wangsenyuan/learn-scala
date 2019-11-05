package set1000.set1000.set1050.p1053

object Solution {
  def prevPermOpt1(A: Array[Int]): Array[Int] = {
    val n = A.length
    if (n == 1) {
      A
    } else {
      var j = n - 2
      while (j >= 0 && A(j) <= A(j + 1)) {
        j -= 1
      }
      if (j >= 0) {
        var k = j + 1
        var i = j + 2
        while (i < n) {
          if (A(i) < A(j) && A(k) < A(i)) {
            k = i
          }
          i += 1
        }
        A(k) ^= A(j)
        A(j) ^= A(k)
        A(k) ^= A(j)
      }

      A
    }
  }
}
