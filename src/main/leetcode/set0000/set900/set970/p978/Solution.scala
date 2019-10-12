package set0000.set900.set970.p978

object Solution {
  def maxTurbulenceSize(A: Array[Int]): Int = {
    val n = A.length
    if (n == 0) {
      0
    } else {
      var best = 1

      var ans = 1
      var i = 1
      while (i < n) {
        val j = i - 1

        if (A(j) > A(i)) {
          if (j == 0 || A(j - 1) < A(j)) {
            ans += 1
          } else {
            ans = 2
          }
        } else if (A(j) < A(i)) {
          if (j == 0 || A(j - 1) > A(j)) {
            ans += 1
          } else {
            ans = 2
          }
        } else {
          // A(j) == A(i)
          ans = 1
        }

        best = best max ans


        i += 1
      }

      best
    }

  }
}
