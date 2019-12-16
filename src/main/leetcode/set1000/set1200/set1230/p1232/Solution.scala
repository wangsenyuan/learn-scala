package set1000.set1200.set1230.p1232

import scala.util.Sorting

object Solution {
  def checkStraightLine(coordinates: Array[Array[Int]]): Boolean = {
    val n = coordinates.length

    if (n == 2) {
      true
    } else {

      Sorting.quickSort(coordinates)(Ordering.by(_ (0)))

      val first = coordinates(0)
      val second = coordinates(1)

      var d = 1
      if (second(1) < first(1)) {
        d = -1
      }

      val g = gcd(second(0) - first(0), d * (second(1) - first(1)))

      val dx = (second(0) - first(0)) / g
      val dy = (second(1) - first(1)) / g

      def check(i: Int): Boolean = {
        val cur = coordinates(i)
        val q = gcd(cur(0) - first(0), d * (cur(1) - first(1)))
        val du = (cur(0) - first(0)) / q
        val dv = (cur(1) - first(1)) / q
        dx == du && dy == dv
      }

      var i = 2

      while (i < n && check(i)) {
        i += 1
      }

      i == n
    }


  }

  def gcd(a: Int, b: Int): Int = {
    if (b == 0) {
      a
    } else {
      gcd(b, a % b)
    }
  }
}
