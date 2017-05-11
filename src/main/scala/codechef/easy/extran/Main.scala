package codechef.easy.extran

import scala.io.StdIn

/**
  * Created by wangsenyuan on 11/05/2017.
  */
object Main {

  def calculateSum(x: Long, y: Long, n: Int) = {
    (x + y) * n / 2
  }

  def solve() = {
    val n = StdIn.readInt()
    val nums = StdIn.readLine().split("\\s+").map(_.toLong)
    // x0 < x1 < others < y1 < y0
    var x0 = Long.MaxValue
    var x1 = Long.MaxValue
    var y0 = Long.MinValue
    var y1 = Long.MinValue
    var sum = 0L
    var i = 0
    while (i < n) {
      val x = nums(i)
      if (x <= x0) {
        x1 = x0
        x0 = x
      } else if (x < x1) {
        x1 = x
      }

      if (x >= y0) {
        y1 = y0
        y0 = x
      } else if (x > y1) {
        y1 = x
      }

      sum += x
      i += 1
    }

    val res =
      if (x0 + 1 < x1) {
        x0
      } else if (y0 - 1 > y1) {
        y0
      } else {
        sum - calculateSum(x0, y0, n - 1)
      }

    println(res)
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()
    (0 until t) foreach {
      _ => solve()
    }
  }
}
