package set1000.set1300.set1310.p1317

object Solution {
  def getNoZeroIntegers(n: Int): Array[Int] = {
    var x = 1
    while (x <= n / 2) {
      if (!containsZero(x)) {
        val y = n - x
        if (!containsZero(y)) {
          return Array(x, y)
        }
      }
      x += 1
    }
    Array()
  }

  private def containsZero(num: Int): Boolean = {
    var foundZero = false
    var x = num
    while (x > 0 && !foundZero) {
      val r = x % 10
      foundZero = r == 0
      x /= 10
    }
    foundZero
  }
}
