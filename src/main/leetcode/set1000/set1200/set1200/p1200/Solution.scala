package set1000.set1200.set1200.p1200

import scala.collection.mutable.ListBuffer
import scala.util.Sorting

object Solution {
  def minimumAbsDifference(arr: Array[Int]): List[List[Int]] = {
    Sorting.quickSort(arr)

    var res = arr(1) - arr(0)
    var i = 1
    while (i < arr.length - 1) {
      res = res min (arr(i + 1) - arr(i))
      i += 1
    }

    val ans = ListBuffer.empty[List[Int]]

    i = 0
    while (i < arr.length - 1) {
      if (arr(i + 1) - arr(i) == res) {
        ans += List(arr(i), arr(i + 1))
      }
      i += 1
    }

    ans.toList
  }
}
