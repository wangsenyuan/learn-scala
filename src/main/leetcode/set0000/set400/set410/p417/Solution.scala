package set0000.set400.set410.p417

import scala.collection.mutable.ListBuffer

object Solution {

  val dd = Array(-1, 0, 1, 0, -1)

  def pacificAtlantic(matrix: Array[Array[Int]]): List[Array[Int]] = {
    val m = matrix.length
    if (m == 0) {
      Nil
    } else {
      val n = matrix(0).length
      val flags = Array.ofDim[Int](m * n)

      val que = Array.ofDim[Int](m * n)

      var front = 0
      var tail = 0
      for {
        i <- 0 until m
      } {
        que(tail) = i * n
        flags(i * n) = 1
        tail += 1
      }

      for {
        j <- 1 until n
      } {
        que(tail) = j
        flags(j) = 1
        tail += 1
      }

      while (front < tail) {
        val cur = que(front)
        front += 1
        val x = cur / n
        val y = cur % n
        for {
          k <- 0 until 4
          u = x + dd(k)
          v = y + dd(k + 1)
          if (u >= 0 && u < m)
          if (v >= 0 && v < n)
          if (flags(u * n + v) == 0 && matrix(u)(v) >= matrix(x)(y))
        } {
          flags(u * n + v) |= 1
          que(tail) = u * n + v
          tail += 1
        }
      }

      front = 0
      tail = 0
      for {
        i <- 0 until m
      } {
        que(tail) = i * n + n - 1
        flags(i * n + n - 1) |= 2
        tail += 1
      }

      for {
        j <- 0 until n - 1
      } {
        que(tail) = (m - 1) * n + j
        flags((m - 1) * n + j) |= 2
        tail += 1
      }

      while (front < tail) {
        val cur = que(front)
        front += 1
        val x = cur / n
        val y = cur % n
        for {
          k <- 0 until 4
          u = x + dd(k)
          v = y + dd(k + 1)
          if (u >= 0 && u < m)
          if (v >= 0 && v < n)
          if ((flags(u * n + v) & 2) == 0 && matrix(u)(v) >= matrix(x)(y))
        } {
          flags(u * n + v) |= 2
          que(tail) = u * n + v
          tail += 1
        }
      }

      val res = ListBuffer.empty[Array[Int]]
      for {
        i <- 0 until m
        j <- 0 until n
        if (flags(i * n + j) == 3)
      } {
        res += Array(i, j)
      }

      res.toList
    }
  }
}
