package set1000.set1000.set1070.p1072

object Solution {
  def maxEqualRowsAfterFlips(matrix: Array[Array[Int]]): Int = {
    val m = matrix.length

    val n = matrix(0).length

    val flip = Array.ofDim[Int](n)

    var ans = 0

    for {
      i <- 0 until m
    } {
      // make row(i) all equal by flipping, then check how many rows equal

      for {
        j <- 0 until n
      } {
        flip(j) = 1 - matrix(i)(j)
      }

      var cnt = 0

      for {
        k <- 0 until m
        if sameRow(matrix(k), matrix(i)) || sameRow(matrix(k), flip)
      } {
        cnt += 1
      }

      ans = ans max cnt
    }

    ans
  }

  private def sameRow(a: Array[Int], b: Array[Int]): Boolean = {
    var i = 0
    while (i < a.length && a(i) == b(i)) {
      i += 1
    }
    i == a.length
  }
}
