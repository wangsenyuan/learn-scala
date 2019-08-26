package set0000.set300.set360.p365

object Solution {
  def canMeasureWater(x: Int, y: Int, z: Int): Boolean = {
    if (x == 0 && y == 0) {
      z == 0
    } else if (x == 0) {
      z == 0 || z == y
    } else if (y == 0) {
      z == 0 || z == x
    } else if (z > x + y) {
      false
    } else {
      val g = gcd(x, y)
      z % g == 0
    }
  }

  private def gcd(x: Int, y: Int): Int = {
    var a = x
    var b = y
    while (b > 0) {
      val c = a
      a = b
      b = c % b
    }
    a
  }
}
