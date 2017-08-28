package codechef.easy.rdf

import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val n = 100000
    val m = 37

    val df = Array.fill(n + 1, m + 1)(0d)

    var i = 0
    while (i <= n) {
      df(i)(0) = i
      i += 1
    }

    var j = 1
    while (j <= m) {

      var sum = 0.0
      (1 to n) foreach {
        i =>
          sum += df(i - 1)(j - 1)
          df(i)(j) = sum / i
      }

      j += 1
    }


    val t = StdIn.readInt()
    i = 0
    while (i < t) {
      solve(df)
      i += 1
    }
  }

  def solve(df: Array[Array[Double]]): Unit = {
    val line = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = line(0)
    val k = line(1)

    /*def go(x: Int, k: Int, res: Double): Double = {
      if (x == 0) {
        0.0
      } else if (k == 0) {
        x * res
      } else {
        (0 until x).map(y => go(y, k - 1, res / x)).sum
      }
    }*/

    if (k > 36) {
      println(0.0)
    } else {
      val ans = df(n)(k)
      println(f"$ans%.6f")
    }
  }
}
