package set0000.set900.set940.p941

object Solution {
  def validMountainArray(A: Array[Int]): Boolean = {
    val n = A.length

    if (n < 3) {
      false
    } else if (A(0) >= A(1)) {
      false
    } else {
      var i = 1
      while (i < n && A(i) > A(i - 1)) {
        i += 1
      }
      // i == n || A(i) <= A(i - 1)
      if (i == n || A(i) == A(i - 1)) {
        false
      } else {
        while (i < n && A(i) < A(i - 1)) {
          i += 1
        }
        i == n
      }
    }
  }
}
