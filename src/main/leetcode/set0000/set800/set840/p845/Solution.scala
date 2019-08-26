package set0000.set800.set840.p845

object Solution {
  def longestMountain(A: Array[Int]): Int = {
    val n = A.length

    if (n < 3) {
      0
    } else {
      var best = 0
      var j = 0
      var i = 0
      while (i < n - 1) {
        if (i > j && A(i) > A(j) && A(i) > A(i + 1)) {
          // a candidate
          var k = i + 1
          while (k < n && A(k) < A(k - 1)) {
            k += 1
          }

          best = best max (k - j)
          j = k - 1
          i = k - 1
        } else {
          i += 1
          if (A(i) <= A(i - 1)) {
            j = i
          }
        }
      }
      if(best < 3) {
        0
      } else {
        best
      }
    }
  }
}
