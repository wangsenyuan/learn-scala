package set0000.set400.set450.p452

import scala.util.Sorting

object Solution {
  def findMinArrowShots(points: Array[Array[Int]]): Int = {
    if(points.isEmpty) {
      0
    } else {
      Sorting.quickSort(points)(new Ordering[Array[Int]]() {
        override def compare(x: Array[Int], y: Array[Int]): Int = {
          if (x(1) < y(1)) {
            -1
          } else if (x(1) > y(1)) {
            1
          } else {
            0
          }
        }
      })

      var lastShot = points(0)(1)
      var res = 1
      for {
        i <- 1 until points.length
      } {
        val point = points(i)
        val a = point(0)
        val b = point(1)
        if(a > lastShot) {
          res += 1
          lastShot = b
        }
      }

      res
    }
  }
}
