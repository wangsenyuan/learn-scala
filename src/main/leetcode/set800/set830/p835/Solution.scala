package set800.set830.p835

object Solution {
  def largestOverlap(A: Array[Array[Int]], B: Array[Array[Int]]): Int = {
    val n = A.length

    def check(x: Int, y: Int, A: Array[Array[Int]], B: Array[Array[Int]]): Int = {
      // x y is the position in A align to (0, 0) in B
      var cnt = 0
      for {
        i <- 0 until n
        if i + x < n
        j <- 0 until n
        if j + y < n
      } {
        cnt += A(i + x)(j + y) & B(i)(j)
      }

      cnt
    }

    var best = 0

    for {
      i <- 0 until n
      j <- 0 until n
    } {
      best = best max check(i, j, A, B)
      best = best max check(i, j, B, A)
    }

    best
  }
}
