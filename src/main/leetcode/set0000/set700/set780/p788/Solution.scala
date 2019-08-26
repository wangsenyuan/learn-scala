package set0000.set700.set780.p788

object Solution {
  val ii = Array(0, 1, 5, -1, -1, 2, 9, -1, 8, 6)

  def rotatedDigits(N: Int): Int = {
    (2 to N).count(good)
  }

  private def good(num: Int): Boolean = {
    var x = num
    var res = 0
    var base = 1
    while (x > 0) {
      val y = x % 10
      x /= 10
      val z = ii(y)
      if (z < 0) {
        return false
      }
      res = z * base + res
      base *= 10
    }

    res != num
  }


}
