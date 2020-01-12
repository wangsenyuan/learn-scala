package set1000.set1300.set1310.p1314

object Solution {
  def matrixBlockSum(mat: Array[Array[Int]], K: Int): Array[Array[Int]] = {
    val m = mat.length
    val n = mat(0).length
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
      sum(i)(j) += mat(i)(j)
    }

    val res = Array.ofDim[Int](m, n)

    for {
      i <- 0 until m
      j <- 0 until n
    } {
      val a = (i - K) max 0
      val b = (j - K) max 0
      val c = (i + K) min (m - 1)
      val d = (j + K) min (n - 1)
      var ans = sum(c)(d)

      if (a > 0) {
        ans -= sum(a - 1)(d)
      }
      if (b > 0) {
        ans -= sum(c)(b - 1)
      }

      if (a > 0 && b > 0) {
        ans += sum(a - 1)(b - 1)
      }
      res(i)(j) = ans
    }

    res
  }
}
