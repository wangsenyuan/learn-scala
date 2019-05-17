package set600.set660.p661

object Solution {
  def imageSmoother(M: Array[Array[Int]]): Array[Array[Int]] = {
    if (M.length == 0 || M(0).length == 0) {
      Array()
    } else {

      val m = M.length
      val n = M(0).length

      def smooth(i: Int, j: Int): Int = {
        var sum = 0
        var cnt = 0

        for {
          u <- -1 to 1
          v <- -1 to 1
          x = i + u
          y = j + v
          if (x >= 0 && x < m && y >= 0 && y < n)
        } {
          sum += M(x)(y)
          cnt += 1
        }

        sum / cnt
      }

      val res = Array.ofDim[Int](m, n)

      var i = 0
      while (i < m) {
        var j = 0
        while (j < n) {
          res(i)(j) = smooth(i, j)
          j += 1
        }
        i += 1
      }

      res
    }
  }
}
