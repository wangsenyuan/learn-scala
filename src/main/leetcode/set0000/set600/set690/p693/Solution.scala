package set0000.set600.set690.p693

object Solution {
  def hasAlternatingBits(n: Int): Boolean = {
    if (n <= 2) {
      true
    } else {
      var num = n
      var prev = num & 1
      num >>= 1
      while (num > 0 && (num & 1) != prev) {
        prev = num & 1
        num >>= 1
      }

      num == 0
    }
  }
}
