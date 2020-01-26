package set1000.set1300.set1320.p1329

import scala.util.Sorting

object Solution {
  def diagonalSort(mat: Array[Array[Int]]): Array[Array[Int]] = {
    val m = mat.length
    val n = mat(0).length

    var i = n - 1
    while (i >= 0) {
      val l = (n - i) min m
      val arr = Array.ofDim[Int](l)
      var j = 0
      while (i + j < n && j < m) {
        arr(j) = mat(j)(i + j)
        j += 1
      }

      Sorting.quickSort(arr)

      j = 0
      while (i + j < n && j < m) {
        mat(j)(i + j) = arr(j)
        j += 1
      }

      i -= 1
    }

    i = 1
    while (i < m) {
      val l = n min (m - i)
      val arr = Array.ofDim[Int](l)

      var j = 0
      while (j < n && i + j < m) {
        arr(j) = mat(i + j)(j)
        j += 1
      }

      Sorting.quickSort(arr)

      j = 0
      while (j < n && i + j < m) {
        mat(i + j)(j) = arr(j)
        j += 1
      }
      i += 1
    }

    mat
  }
}
