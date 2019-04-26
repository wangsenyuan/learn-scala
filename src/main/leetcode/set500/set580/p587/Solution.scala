package set500.set580.p587

import scala.collection.mutable.ArrayBuffer

object Solution {
  def outerTrees(points: Array[Array[Int]]): Array[Array[Int]] = {
    val n = points.length
    var first = 0

    for {
      i <- 1 until n
      if (points(i)(0) < points(first)(0))
    } {
      first = i
    }

    val flag = Array.ofDim[Boolean](n)
    flag(first) = true

    var cur = first
    do {
      var next = 0

      for {
        i <- 1 until n
        if (i != cur)

      } {
        val c = crossProduct(points(i), points(cur), points(next))
        if (next == cur || c > 0 || (c == 0 && distance(points(i), points(cur)) > distance(points(next), points(cur)))) {
          next = i
        }
      }

      for {
        i <- 0 until n
        if (!flag(i))
        c = crossProduct(points(i), points(cur), points(next))
        if (c == 0)
      } {
        flag(i) = true
      }

      cur = next
    } while (cur != first)

    val res = ArrayBuffer.empty[Array[Int]]

    for {
      i <- 0 until n
      if flag(i)
    } {
      res += points(i)
    }

    res.toArray
  }

  private def crossProduct(a: Array[Int], b: Array[Int], c: Array[Int]): Int = {
    val bax = b(0) - a(0)
    val bay = b(1) - a(1)
    val bcx = c(0) - b(0)
    val bcy = c(1) - b(1)

    bax * bcy - bcx * bay
  }

  private def distance(a: Array[Int], b: Array[Int]): Int = {
    val x = a(0) - b(0)
    val y = a(1) - b(1)
    x * x + y * y
  }
}
