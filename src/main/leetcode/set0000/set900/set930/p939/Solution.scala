package set0000.set900.set930.p939

import scala.collection.mutable
import scala.util.Sorting

object Solution {

  case class Line(y: Int, h: Int)

  def minAreaRect(points: Array[Array[Int]]): Int = {
    Sorting.quickSort(points)(Ordering.fromLessThan(((a, b) => {
      a(0) < b(0) || (a(0) == b(0) && a(1) < b(1))
    })))

    val lines = mutable.Map.empty[Line, Int]
    var res = -1

    var j = 0
    var i = 1
    while (i <= points.length) {
      if (i == points.length || points(j)(0) < points(i)(0)) {
        val x = points(j)(0)

        var u = j
        while (u < i) {
          var v = u + 1
          while (v < i) {
            val h = points(v)(1) - points(u)(1)
            val y = points(u)(1)
            val line = Line(y, h)

            if (lines.contains(line)) {
              val tmp = h * (x - lines(line))
              if (res < 0 || res > tmp) {
                res = tmp
              }
            }
            lines += line -> x

            v += 1
          }
          u += 1
        }

        j = i
      }

      i += 1
    }

    0 max res
  }
}
