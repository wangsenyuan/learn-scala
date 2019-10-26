package set1000.set1000.set1020.p1020

object Solution {
  def numEnclaves(A: Array[Array[Int]]): Int = {
    val m = A.length
    val n = A(0).length

    var totalOnes = 0
    val que = Array.ofDim[Int](m * n)
    var end = 0
    val vis = Array.ofDim[Boolean](m * n)

    for {
      i <- 0 until m
      j <- 0 until n
      if A(i)(j) == 1
    } {
      totalOnes += 1
      if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
        que(end) = i * n + j
        end += 1
        vis(i * n + j) = true
      }
    }

    val dd = Array(-1, 0, 1, 0, -1)

    var front = 0

    while (front < end) {
      val cur = que(front)
      front += 1
      val x = cur / n
      val y = cur % n

      for {
        k <- 0 until 4
        u = x + dd(k)
        v = y + dd(k + 1)
        if u >= 0 && u < m && v >= 0 && v < n && !vis(u * n + v) && A(u)(v) == 1
      } {
        que(end) = u * n + v
        end += 1
        vis(u * n + v) = true
      }
    }

    totalOnes - vis.count(identity)
  }
}
