package set0000.set800.set800.p808

import scala.collection.mutable

object Solution {

  def soupServings(N: Int): Double = {

    if (N > 10000) {
      1.0
    } else {
      val mem = mutable.Map.empty[(Int, Int), Double]

      def calc(a: Int, b: Int): Double = {
        val k = (a, b)
        if (mem.contains(k)) {
          mem(k)
        } else if (a <= 0 && b <= 0) {
          0.5d
        } else if (a <= 0) {
          1.0d
        } else if (b <= 0) {
          0.0d
        } else {
          val res = 0.25d * (calc(a - 100, b) + calc(a - 75, b - 25) + calc(a - 50, b - 50) + calc(a - 25, b - 75))
          mem(k) = res
          res
        }
      }

      calc(N, N)
    }


  }
}
