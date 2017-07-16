package codechef.easy.bandmatr

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/7/16.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    var i = 0
    while (i < t) {
      solve()
      i += 1
    }
  }

  def solve(): Unit = {
    val n = StdIn.readInt()

    var cnt = 0

    var i = 0
    while (i < n) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      cnt += line.count(_ == 1)
      i += 1
    }

    def calculate(x: Int): Int = {
      n + x * (2 * n - x - 1) - cnt
    }

    if (cnt <= n) {
      println(0)
    } else {
      var min = 1
      var max = n

      while (min < max) {
        val mid = (min + max) / 2
        val tmp = calculate(mid)
        if (tmp >= 0) {
          max = mid
        } else {
          min = mid + 1
        }
      }

      println(max)
    }
  }
}
