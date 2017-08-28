package codechef.easy.lemouse

import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()
    var i = 0
    while (i < t) {
      solve()
      i += 1
    }
  }

  val dd = Array(-1, 0, 1, 0, -1)

  def solve(): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val m = firstLine(1)

    val mouse = Array.fill[Array[Int]](n)(null)

    var i = 0
    while (i < n) {
      mouse(i) = StdIn.readLine().map(c => (c - '0')).toArray
      i += 1
    }

    val shadow = Array.fill(n, m)(0)

    i = 0
    while (i < n) {
      var j = 0
      while (j < m) {
        if (mouse(i)(j) == 1) {
          if (i - 1 >= 0) {
            shadow(i - 1)(j) += 1
          }
          if (i + 1 < n) {
            shadow(i + 1)(j) += 1
          }
          if (j - 1 >= 0) {
            shadow(i)(j - 1) += 1
          }
          if (j + 1 < m) {
            shadow(i)(j + 1) += 1
          }
        }
        j += 1
      }

      i += 1
    }

    val dp = Array.fill(n, m, 2)(Int.MaxValue)

    dp(0)(0)(0) = shadow(0)(0) - mouse(0)(0)
    dp(0)(0)(1) = shadow(0)(0) - mouse(0)(0)

    i = 0
    while (i < n) {
      var j = 0
      while (j < m) {
        if (i == 0 && j == 0) {
          // top-left
        } else if (i == 0) {
          dp(0)(j)(0) = shadow(0)(j) - mouse(0)(j) + dp(0)(j - 1)(0)
        } else if (j == 0) {
          dp(i)(0)(1) = shadow(i)(0) - mouse(i)(0) + dp(i - 1)(j)(1)
        } else {
          dp(i)(j)(0) = shadow(i)(j) - mouse(i)(j) + (dp(i)(j - 1)(0) min (dp(i)(j - 1)(1) - mouse(i - 1)(j)))
          dp(i)(j)(1) = shadow(i)(j) - mouse(i)(j) + (dp(i - 1)(j)(1) min (dp(i - 1)(j)(0)) - mouse(i)(j - 1))
        }

        j += 1
      }

      i += 1
    }

    val best = (dp(n - 1)(m - 1)(0) min dp(n - 1)(m - 1)(1)) + mouse(0)(0) + mouse(n - 1)(m - 1)

    println(best)
  }
}
