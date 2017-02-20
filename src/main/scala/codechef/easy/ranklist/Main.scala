package codechef.easy.ranklist

import scala.io.StdIn

/**
  * Created by wangsenyuan on 18/02/2017.
  */
object Main {

  def calculate(n: Long, s: Long): Long = {
    var y = Long.MaxValue
    var x = 1L

    while (x <= n) {
      val a = x * (x + 1) / 2
      val b = a + n - x
      val c = a + (n - x) * x
      if (b <= s && c >= s && y > (n - x)) {
        y = n - x
      }

      x += 1
    }
    y
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      val line = StdIn.readLine().split("\\s+").map(_.toLong)
      val n = line(0)
      val s = line(1)
      val r = calculate(n, s)
      println(r)

      t -= 1
    }
  }
}
