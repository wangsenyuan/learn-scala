package set0000.set900.set960.p960

object Solution {
  def minDeletionSize(A: Array[String]): Int = {
    val m = A.length
    val n = A(0).length
    // dp(i) = non-decrement seq length ending at i

    var ans = 1
    val fp = Array.ofDim[Int](n)
    fp(0) = 1

    var j = 1
    while (j < n) {
      // first try to keep it
      // fp(j) = fp(k) + 1 with
      fp(j) = 1
      var k = j - 1
      while (k >= 0) {
        var i = 0
        while (i < m && A(i)(j) >= A(i)(k)) {
          i += 1
        }

        if (i == m) {
          // we can append j after k
          fp(j) = fp(j) max (fp(k) + 1)
        }

        k -= 1
      }

      ans = ans max fp(j)

      j += 1
    }

    n - ans
  }
}
