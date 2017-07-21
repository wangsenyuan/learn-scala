package codechef.easy.chsqr

import scala.io.StdIn

object Main {

  def solve() = {
    val n = StdIn.readInt()
    val matrix = Array.fill(n, n)(0)

    var i = 0
    while (i < n) {
      var j = 0
      while (j < n) {
        matrix(i)(j) = ((n + 1) / 2 + i + j) % n + 1
        j += 1
      }
      i += 1
    }

    matrix.foreach {
      row =>
        println(row.mkString(" "))
    }
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    var i = 0
    while (i < t) {
      solve()
      i += 1
    }
  }
}
