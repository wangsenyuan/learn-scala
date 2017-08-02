package codechef.easy.ftrip

import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val comb = preComputeComb(1000)

    val t = StdIn.readInt()
    var i = 0
    while (i < t) {
      solve(comb)
      i += 1
    }
  }

  def preComputeComb(n: Int): Array[Array[Long]] = {
    val c = Array.fill(n + 1, n + 1)(0L)
    c(0)(0) = 1

    var i = 1
    while (i <= n) {
      var j = 0
      while (j < i) {
        c(i)(j) = c(i - 1)(j)
        if (j > 0) {
          c(i)(j) = (c(i)(j) + c(i - 1)(j - 1))
        }
        j += 1
      }

      c(i)(i) = 1

      i += 1
    }

    c
  }

  def solve(comb: Array[Array[Long]]): Unit = {
    val line = StdIn.readLine().split("\\s+").map(_.toInt)
    val s = line(0)
    val n = line(1)
    val m = line(2)
    val k = line(3)

    var num = 0L

    var x = k max (n - 1 + m - s)
    while (x <= ((n - 1) min (m - 1))) {
      num += comb(m - 1)(x) * comb(s - m)(n - 1 - x)
      x += 1
    }

    val ans = 1.0d * num / comb(s - 1)(n - 1)
    println(f"$ans%.6f")
  }


}
