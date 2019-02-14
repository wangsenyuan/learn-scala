package set300.set360.p363

object Solution {
  def maxSumSubmatrix(matrix: Array[Array[Int]], k: Int): Int = {
    val m = matrix.length
    val n = matrix(0).length
    if (m <= n) {
      cal(matrix, k, m, n)
    } else {
      cal(matrix.transpose, k, n, m)
    }
  }

  private def cal(matrix: Array[Array[Int]], target: Int, m: Int, n: Int): Int = {
    //m <= n
    val set = new java.util.TreeSet[Int]()
    val cols = Array.ofDim[Int](n)
    var i = 0

    var diff = Int.MaxValue / 2
    var ans = 0

    while (i < m) {
      (0 until n) foreach (j => cols(j) = 0)

      var j = i

      while (j >= 0) {
        set.clear()
        set.add(0)
        set.add(Int.MaxValue / 2)
        var sum = 0

        var u = 0
        while (u < n) {
          cols(u) += matrix(j)(u)
          sum += cols(u)

          val tmp = set.ceiling(sum - target)
          val candidate = sum - tmp

          if ((target - candidate).abs < diff) {
            diff = (target - candidate).abs
            ans = candidate
          }
          set.add(sum)

          u += 1
        }

        j -= 1
      }

      i += 1
    }

    ans
  }
}
