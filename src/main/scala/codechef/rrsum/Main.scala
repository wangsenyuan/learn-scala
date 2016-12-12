package codechef.rrsum

import scala.io.StdIn

/**
  * Created by wangsenyuan on 12/12/2016.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val line = StdIn.readLine().split("\\s+").map(_.toLong)
    val n = line(0)
    var m = line(1)

    while (m > 0) {
      m -= 1
      val x = StdIn.readLong()
      val y = calculate(n, x)
      println(y)
    }
  }

  def calculate(n: Long, x: Long): Long = {
    if (x < n + 2 || x > 3 * n) {
      0
    } else {
      val z = 2 * n + 1
      if (x >= z) {
        n - (x - z)
      } else {
        n - (z - x)
      }
    }
  }
}
