package codechef.easy.mgcrnk

import scala.io.StdIn

/**
  * Created by wangsenyuan on 16/01/2017.
  */
object Main {

  def evaluate(s: Array[Array[Int]], n: Int): Double = {
    if (n <= 1) {
      -1.0d
    } else {
      val f = Array.fill(n, n)(Int.MinValue)

      f(0)(0) = 0
      for {
        i <- 0 until n
        j <- 0 until n
      } {
        if (i > 0 && f(i - 1)(j) + s(i)(j) > f(i)(j)) {
          f(i)(j) = f(i - 1)(j) + s(i)(j)
        }

        if (j > 0 && f(i)(j - 1) + s(i)(j) > f(i)(j)) {
          f(i)(j) = f(i)(j - 1) + s(i)(j)
        }
      }


      1.0d * f(n - 1)(n - 1) / (2 * n - 3)
    }
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      val n = StdIn.readInt()
      val s = Array.fill[Array[Int]](n)(null)

      var i = 0
      while (i < n) {
        val corridor = StdIn.readLine().split("\\s+").map(_.toInt)
        s(i) = corridor
        i += 1
      }

      val res = evaluate(s, n)

      if (res < 0.0) {
        println("Bad Judges")
      } else {
        println(res)
      }

      t -= 1
    }
  }
}
