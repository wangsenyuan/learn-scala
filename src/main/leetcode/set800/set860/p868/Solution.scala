package set800.set860.p868

object Solution {
  def binaryGap(N: Int): Int = {
    if (N == 0) {
      0
    } else {
      var num = N

      while ((num & 1) == 0) {
        num >>= 1
      }

      var ans = 0
      var d = 0

      while (num > 0) {
        val x = num & 1
        if (x == 1) {
          ans = ans max d
          d = 1
        } else {
          d += 1
        }
        num >>= 1
      }

      ans
    }

  }
}
