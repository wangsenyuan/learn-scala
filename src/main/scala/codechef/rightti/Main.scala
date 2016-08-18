package codechef.rightti

import scala.io.StdIn

/**
  * Created by wangsenyuan on 8/18/16.
  */
object Main {

  def main(args: Array[String]): Unit = {
    var n = StdIn.readInt()
    var x = 0
    while (n > 0) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)

      val x1 = line(0)
      val y1 = line(1)
      val x2 = line(2)
      val y2 = line(3)
      val x3 = line(4)
      val y3 = line(5)

      if (isRightTriangle(x1, y1, x2, y2, x3, y3)) {
        x += 1
      }

      n -= 1
    }

    println(x)
  }

  private def isRightTriangle(x1: Int, y1: Int, x2: Int, y2: Int, x3: Int, y3: Int): Boolean = {
    val a = length(x1, y1, x2, y2)
    val b = length(x2, y2, x3, y3)
    val c = length(x1, y1, x3, y3)

    a > 0 && b > 0 && c > 0 && (a + b == c || a + c == b || b + c == a)
  }

  private def length(x1: Int, y1: Int, x2: Int, y2: Int): Int = {
    (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1)
  }
}
