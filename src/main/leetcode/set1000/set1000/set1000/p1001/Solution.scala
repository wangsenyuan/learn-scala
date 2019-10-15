package set1000.set1000.set1000.p1001

import scala.collection.mutable

object Solution {
  def gridIllumination(N: Int, lamps: Array[Array[Int]], queries: Array[Array[Int]]): Array[Int] = {
    val row = mutable.Map.empty[Int, Int].withDefaultValue(0)
    val col = mutable.Map.empty[Int, Int].withDefaultValue(0)
    val diag1 = mutable.Map.empty[Int, Int].withDefaultValue(0)
    val diag2 = mutable.Map.empty[Int, Int].withDefaultValue(0)

    val board = mutable.Set.empty[(Int, Int)]

    for {
      lamp <- lamps
    } {
      val x = lamp(0)
      val y = lamp(1)
      row(x) += 1
      col(y) += 1
      diag1(x + y) += 1
      diag2(N - 1 - x + y) += 1
      board += x -> y
    }

    val res = Array.ofDim[Int](queries.length)

    for {
      i <- 0 until queries.length
    } {
      val x = queries(i)(0)
      val y = queries(i)(1)
      if (row(x) > 0 || col(y) > 0 || diag1(x + y) > 0 || diag2(N - 1 - x + y) > 0) {
        res(i) = 1
        for {
          a <- x - 1 to x + 1
          b <- y - 1 to y + 1
          if a >= 0 && a < N && b >= 0 && b < N && board(a -> b)
        } {
          board -= a -> b
          row(a) -= 1
          col(b) -= 1
          diag1(a + b) -= 1
          diag2(N - 1 - a + b) -= 1
        }
      }
    }

    res
  }
}
