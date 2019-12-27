package set1000.set1200.set1270.p1277

object Solution {
  def countSquares(matrix: Array[Array[Int]]): Int = {
    val m = matrix.length
    val n = matrix(0).length
    val sum = Array.ofDim[Int](m, n)

    for {
      i <- 0 until m
      j <- 0 until n
    } {
      if (i > 0) {
        sum(i)(j) += sum(i - 1)(j)
      }
      if (j > 0) {
        sum(i)(j) += sum(i)(j - 1)
      }
      if (i > 0 && j > 0) {
        sum(i)(j) -= sum(i - 1)(j - 1)
      }
      sum(i)(j) += matrix(i)(j)
    }
    var res = 0
    for {
      i <- 0 until m
      j <- 0 until n
    } {
      var can = true
      var k = 1
      while (i + k <= m && j + k <= n && can) {
        val x = i + k - 1
        val y = j + k - 1
        var tmp = sum(x)(y)
        if (i > 0) {
          tmp -= sum(i - 1)(y)
        }
        if (j > 0) {
          tmp -= sum(x)(j - 1)
        }
        if (i > 0 && j > 0) {
          tmp += sum(i - 1)(j - 1)
        }

        can = tmp == k * k

        if (can) {
          res += 1
        }

        k += 1
      }
    }
    res
  }
}
