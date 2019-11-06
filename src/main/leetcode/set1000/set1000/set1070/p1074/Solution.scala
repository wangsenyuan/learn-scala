package set1000.set1000.set1070.p1074

import scala.collection.mutable

object Solution {
  def numSubmatrixSumTarget(matrix: Array[Array[Int]], target: Int): Int = {
    val m = matrix.length
    val n = matrix(0).length
    val sums = Array.ofDim[Int](m, n)

    for {
      i <- 0 until m
      j <- 0 until n
    } {
      sums(i)(j) = matrix(i)(j)
      if (i > 0) {
        sums(i)(j) += sums(i - 1)(j)
      }
    }
    val dp = mutable.Map.empty[Int, Int].withDefaultValue(0)
    var res = 0
    for {
      i <- 0 until m
      k <- i until m
    } {
      dp.clear()
      dp(0) = 1
      var tmp = 0
      for {
        j <- 0 until n
      } {
        tmp += sums(k)(j)
        if (i > 0) {
          tmp -= sums(i - 1)(j)
        }

        res += dp(tmp - target)
        dp(tmp) += 1
      }
    }

    res
  }

}
