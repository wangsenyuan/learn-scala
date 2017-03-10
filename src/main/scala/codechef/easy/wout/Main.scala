package codechef.easy.wout

import scala.io.StdIn

/**
  * Created by wangsenyuan on 10/03/2017.
  */
object Main {

  def solve() = {
    val line = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = line(0)
    val h = line(1)

    val ds = Array.fill(n)(0)

    var i = 0
    while (i < n) {
      val col = StdIn.readLine().split("\\s+").map(_.toInt)

      val l = col(0)
      val h = col(1)

      ds(l) -= 1

      if (h + 1 < n) {
        ds(h + 1) += 1
      }

      i += 1
    }

    var prev = n
    val ss = Array.fill(n + 1)(0L)
    i = 0
    while (i < n) {
      ds(i) += prev
      ss(i + 1) = ss(i) + ds(i)
      prev = ds(i)
      i += 1
    }

    var best = 1L * h * n
    i = 0
    while (i + h <= n) {
      val ans = ss(i + h) - ss(i)

      if (ans < best) {
        best = ans
      }
      i += 1
    }

    println(best)
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
