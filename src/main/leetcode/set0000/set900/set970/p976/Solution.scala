package set0000.set900.set970.p976

import scala.util.Sorting

object Solution {
  def largestPerimeter(A: Array[Int]): Int = {
    Sorting.quickSort(A)

    var i = A.length - 1
    while (i >= 2) {
      val a = A(i - 2)
      val b = A(i - 1)
      val c = A(i)

      if (a + b > c) {
        return a + b + c
      }

      i -= 1
    }

    0
  }
}
