package set1000.set1200.set1260.p1260

import scala.collection.mutable.ListBuffer

object Solution {
  def shiftGrid(grid: Array[Array[Int]], k: Int): List[List[Int]] = {
    val m = grid.length
    val n = grid(0).length
    val K = k % (m * n)

    val buf = Array.ofDim[Int](m * n)
    for {
      i <- 0 until m
      j <- 0 until n
    } {
      buf(i * n + j) = grid(i)(j)
    }

    swap(buf, 0, m * n - 1)
    swap(buf, 0, K - 1)
    swap(buf, K, m * n - 1)

    val res = ListBuffer.empty[List[Int]]
    for {
      i <- 0 until m
    } {
      res += buf.slice(i * n, (i + 1) * n).toList
    }

    res.toList
  }

  private def swap(arr: Array[Int], start: Int, end: Int): Unit = {
    var i = start
    var j = end
    while (i < j) {
      arr(i) ^= arr(j)
      arr(j) ^= arr(i)
      arr(i) ^= arr(j)
      i += 1
      j -= 1
    }
  }
}
