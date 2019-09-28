package set0000.set900.set960.p969

import scala.collection.mutable.ListBuffer

object Solution {
  def pancakeSort(A: Array[Int]): List[Int] = {
    val res = ListBuffer.empty[Int]
    val n = A.length
    var i = n

    while (i > 0) {
      var j = 0
      while (j < n && A(j) != i) {
        j += 1
      }

      // A(j) == i
      if (j != i - 1) {
        // then swap twice
        res += j + 1
        swap(A, 0, j)
        res += i
        swap(A, 0, i - 1)
      }

      i -= 1
    }
    res.toList
  }

  private def swap(arr: Array[Int], x: Int, y: Int) = {
    var i = x
    var j = y
    while (i < j) {
      val tmp = arr(i)
      arr(i) = arr(j)
      arr(j) = tmp
      i += 1
      j -= 1
    }
  }
}
