package set0000.set900.set920.p927

object Solution {
  def threeEqualParts(A: Array[Int]): Array[Int] = {
    val sum = A.sum
    if (sum % 3 != 0) {
      Array(-1, -1)
    } else if (sum == 0) {
      // all zeros
      Array(0, 2)
    } else {
      val oneThird = sum / 3
      val n = A.length
      var k = n - 1
      var c = 0

      while (A(k) == 0) {
        k -= 1
      }

      val c0 = n - 1 - k

      while (c < oneThird) {
        c += A(k)
        k -= 1
      }
      k += 1
      // k can extends 0 if necessary

      var a = 0
      var i = 0
      while (a < oneThird) {
        a += A(i)
        i += 1
      }

      // A(i - 1) has to be 1
      var a0 = 0
      while (a0 < c0 && A(i) == 0) {
        a0 += 1
        i += 1
      }

      if (a0 < c0) {
        Array(-1, -1)
      } else {
        // we need to compare [0...i) and [0...k...n)
        var x = i - 1
        var y = n - 1
        while (x >= 0 && y >= k && A(x) == A(y)) {
          x -= 1
          y -= 1
        }
        while (x >= 0 && A(x) == 0) {
          // must be leading zeros
          x -= 1
        }
        if (x >= 0 || y >= k) {
          // not match
          Array(-1, -1)
        }
        // then check [i...k)
        var j = i
        y = k
        while (A(j) == 0) {
          j += 1
        }
        // A(j) == 1
        while (j < k && y < n && A(j) == A(y)) {
          j += 1
          y += 1
        }
        if (y == n) {
          Array(i - 1, j)
        } else {
          Array(-1, -1)
        }
      }
    }
  }
}
