package set800.set870.p870

import scala.util.Sorting

object Solution {
  def advantageCount(A: Array[Int], B: Array[Int]): Array[Int] = {
    Sorting.quickSort(A)
    val items = B.zipWithIndex.map(x => Item(x._1, x._2))

    Sorting.quickSort(items)(Ordering.by(_.num))

    val res = Array.fill(A.length)(-1)
    val ii = Array.fill(A.length)(-1)
    var j = 0
    var i = 0
    while (i < A.length) {
      if (A(i) > items(j).num) {
        res(items(j).index) = A(i)
        ii(i) = items(j).index
        j += 1
      }
      i += 1
    }

    j = 0
    i = 0
    while (i < A.length) {
      if (ii(i) < 0) {
        while (res(j) >= 0) {
          j += 1
        }
        res(j) = A(i)
        j += 1
      }
      i += 1
    }

    res
  }

  case class Item(num: Int, index: Int)

}
