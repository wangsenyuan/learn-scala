package set1000.set1200.set1290.p1292

object Solution {
  def maxSideLength(mat: Array[Array[Int]], threshold: Int): Int = {
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

    var res = 0
    for {
      k <- 1 to (m min n)
    } {
      var found = false
      var i = 0
      while (i < m - k + 1 && !found) {
        var j = 0
        while (j < n - k + 1 && !found) {
          val a = i + k - 1
          val b = j + k - 1
          var cnt = sum(a)(b)
          if (i > 0) {
            cnt -= sum(i - 1)(b)
          }
          if (j > 0) {
            cnt -= sum(a)(j - 1)
          }
          if (i > 0 && j > 0) {
            cnt += sum(i - 1)(j - 1)
          }
          if (cnt <= threshold) {
            found = true
          }

          j += 1
        }
        i += 1
      }
      if (found) {
        res = res max k
      }
    }
    res
  }
}
