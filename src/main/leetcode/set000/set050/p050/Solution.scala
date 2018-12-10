package set000.set050.p050

object Solution {

  def myPow(x: Double, n: Int): Double = {
    if (n == 0) {
      1.0
    } else if (n < 0) {
      1.0 / (pow(x, -(n.toLong)))
    } else {
      pow(x, n)
    }
  }

  private def pow(x: Double, n: Long): Double = {
    if (n == 0) {
      1.0d
    } else if (n == 1) {
      x
    } else {
      val y = pow(x, n / 2)
      val z = y * y
      if (n % 2 == 1) {
        z * x
      } else {
        z
      }
    }
  }
}
