package set1000.set1300.set1340.p1341

import scala.util.Sorting

object Solution {
  def kWeakestRows(mat: Array[Array[Int]], k: Int): Array[Int] = {
    val row = mat.map(_.sum).zipWithIndex

    Sorting.quickSort(row)(Ordering.fromLessThan((a, b) => {
      a._1 < b._1 || (a._1 == b._1 && a._2 < b._2)
    }))

    row.take(k).map(_._2)
  }
}
