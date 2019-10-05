package set0000.set900.set970.p973

import scala.util.Sorting

object Solution {
  def kClosest(points: Array[Array[Int]], K: Int): Array[Array[Int]] = {
    Sorting.quickSort(points)(Ordering.by(arr => distance(arr)))
    points.take(K)
  }

  private def distance(arr: Array[Int]): Long = {
    arr(0) * arr(0) + arr(1) * arr(1)
  }
}
