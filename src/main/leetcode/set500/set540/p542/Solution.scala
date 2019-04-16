package set500.set540.p542

object Solution {
  def updateMatrix(matrix: Array[Array[Int]]): Array[Array[Int]] = {
    if (matrix.length == 0 || matrix(0).length == 0) {
      Array()
    } else {
      val m = matrix.length
      val n = matrix(0).length
      val res = Array.fill(m, n)(-1)
      val que = Array.ofDim[Int](m * n)
      var tail = 0
      for {
        i <- 0 until m
        j <- 0 until n
        if (matrix(i)(j) == 0)
      } {
        res(i)(j) = 0
        que(tail) = i * n + j
        tail += 1
      }
      val dd = Array(-1, 0, 1, 0, -1)
      var front = 0
      while (front < tail) {
        val cur = que(front)
        front += 1
        val x = cur / n
        val y = cur % n
        for {
          k <- 0 until 4
          u = x + dd(k)
          v = y + dd(k + 1)
          if (u >= 0 && u < m && v >= 0 && v < n && res(u)(v) < 0)
        } {
          res(u)(v) = res(x)(y) + 1
          que(tail) = u * n + v
          tail += 1
        }
      }

      res
    }
  }
}
