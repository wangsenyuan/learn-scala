package set0000.set800.set820.p829

object Solution {
  def consecutiveNumbersSum(N: Int): Int = {
    // (y + x) * (y - x + 1) = 2 * N
    // (y + x) * (y - x + 1) = 2 * a * b
    // y + x = 2 * a and y - x + 1 = b if 2 * a >= b
    // y + x = 2 * b and y - x + 1 = a if 2 * b >= a
    // y + x = b and y - x + 1 = 2 * a if b >= 2 * a
    // y + x = a and y - x + 1 = 2 * b

    // y - x + 1 == 2
    if (N <= 2) {
      1
    } else {
      val num = N.toLong
      var a = 1L
      var res = 0
      while (a * a <= num) {
        if (num % a == 0) {
          val b = num / a
          val Y = (2 * a + b - 1)
          if ((Y & 1) == 0) {
            val y = Y >> 1
            var x = 2 * a - y
            if (x >= 1 && y >= x && num >= y) {
              res += 1
            }
            x = b - y
            if (x >= 1 && y >= x && num >= y) {
              res += 1
            }
          }
          val Z = (2 * b + a - 1)
          if (Z != Y && ((Z & 1) == 0)) {
            val z = Z >> 1
            var x = 2 * b - z
            if (x >= 1 && z >= x && num >= z) {
              res += 1
            }
            x = a - z
            if (x >= 1 && z >= x && num >= z) {
              res += 1
            }
          }

        }

        a += 1
      }

      res
    }

  }
}
