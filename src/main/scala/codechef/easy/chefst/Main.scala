package codechef.easy.chefst

import scala.annotation.tailrec
import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/3/23.
  */
object Main {

  def calculate(m: Long, n: Long): Long = {
    val a = 1L
    val b = -1L
    val c = 2 * n - m * m + m
    if (b * b < 4 * a * c) {
      1L
    } else {
      val x = math.sqrt(b * b - 4 * a * c)
      val y = (x + 1) * 0.5
      val t = y.toLong
      if (y - t > 10e-7) {
        t + 1
      } else {
        t
      }
    }
  }

  def solve() = {
    val line = StdIn.readLine().split("\\s+").map(_.toLong)
    val n1 = line(0) min line(1)
    val n2 = line(0) max line(1)
    val m = line(2)

    @tailrec
    def go(m: Long, n: Long): Long = {
      if (m >= n) {
        0L
      } else if (m == 0) {
        n
      } else {
        val x = calculate(m, n)
        val y = (m + x) * (m - x + 1) / 2
        go(x - 1, n - y)
      }
    }

    val k = go(m, n1)
    val sum = k + n2 - (n1 - k)
    println(sum)
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
