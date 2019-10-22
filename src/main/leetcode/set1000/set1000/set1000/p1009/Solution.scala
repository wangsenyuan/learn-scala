package set1000.set1000.set1000.p1009

object Solution {
  def bitwiseComplement(N: Int): Int = {
    if (N == 0) {
      1
    } else {
      var res = 0
      var num = N
      var i = 0
      while (num > 0) {
        if ((num & 1) == 0) {
          res |= 1 << i
        }
        i += 1
        num >>= 1
      }
      res
    }
  }
}
