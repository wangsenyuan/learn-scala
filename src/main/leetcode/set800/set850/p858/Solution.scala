package set800.set850.p858

object Solution {
  def mirrorReflection(p: Int, q: Int): Int = {
    val g = gcd(p, q)

    val x = (p / g) % 2
    val y = (q / g) % 2

    if (x == 1 && y == 1) {
      1
    } else if (x == 1) {
      0
    } else {
      2
    }
  }

  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) {
      a
    } else {
      gcd(b, a % b)
    }
  }
}
