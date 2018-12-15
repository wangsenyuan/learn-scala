package set000.set060.p069

object Solution {

  def mySqrt(x: Int): Int = {
    if (x == 0) {
      0
    } else {
      val xx = x.toDouble

      def go(y: Double, n: Int): Double = {
        if (n == 30) {
          y
        } else {
          go((y + xx / y) / 2, n + 1)
        }
      }

      go(xx, 0).toInt
    }
  }
}
