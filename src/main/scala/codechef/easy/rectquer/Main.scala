package codechef.easy.rectquer

import scala.io.StdIn

/**
  * Created by wangsenyuan on 06/04/2017.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()
    val matrix = Array.fill[Array[Int]](n)(null)

    val dp = Array.fill(n, n, 11)(0)

    var i = 0
    while (i < n) {
      matrix(i) = StdIn.readLine().split("\\s+").map(_.toInt)
      var j = 0
      while (j < n) {
        var x = 1
        while (x <= 10) {

          if (i > 0) {
            dp(i)(j)(x) += dp(i - 1)(j)(x)
          }

          if (j > 0) {
            dp(i)(j)(x) += dp(i)(j - 1)(x)
          }

          if (i > 0 && j > 0) {
            dp(i)(j)(x) -= dp(i - 1)(j - 1)(x)
          }

          if (x == matrix(i)(j)) {
            dp(i)(j)(x) += 1
          }

          x += 1
        }

        j += 1
      }
      i += 1
    }

    val q = StdIn.readInt()

    var k = 0
    while (k < q) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val a = line(0) - 1
      val b = line(1) - 1
      val c = line(2) - 1
      val d = line(3) - 1

      var ans = 0
      var x = 1
      while (x <= 10) {

        var y = dp(c)(d)(x)
        if (b > 0) {
          y -= dp(c)(b - 1)(x)
        }

        if (a > 0) {
          y -= dp(a - 1)(d)(x)
        }

        if (a > 0 && b > 0) {
          y += dp(a - 1)(b - 1)(x)
        }

        if (y > 0) {
          ans += 1
        }

        x += 1
      }

      println(ans)

      k += 1
    }

  }
}
