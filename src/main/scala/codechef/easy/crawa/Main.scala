package codechef.easy.crawa

import scala.io.StdIn

/**
  * Created by wangsenyuan on 01/03/2017.
  */
object Main {

  def south(x: Long, y: Long): Boolean = {
    val x0 = 0L
    val y0 = 0L
    val d = y0 - y
    if (d < 0 || d % 2 != 0) {
      false
    } else {
      val k = d / 2
      val x1 = x0 - 2 * k
      val x2 = x1 + 4 * k + 1
      x >= x1 && x <= x2
    }
  }

  def east(x: Long, y: Long): Boolean = {
    val x0 = 1L
    val y0 = 0L
    val d = x - x0
    if (d < 0 || d % 2 != 0) {
      false
    } else {
      val k = d / 2
      val y1 = y0 - 2 * k
      val y2 = y1 + 4 * k + 2
      y >= y1 && y <= y2
    }
  }

  def north(x: Long, y: Long): Boolean = {
    val x0 = 1L
    val y0 = 2L
    val d = y - y0
    if (d < 0 || d % 2 != 0) {
      false
    } else {
      val k = d / 2
      val x1 = x0 + 2 * k
      val x2 = x1 - 4 * k - 3
      x >= x2 && x <= x1
    }
  }

  def west(x: Long, y: Long): Boolean = {
    val x0 = -2L
    val y0 = 2L
    val d = x0 - x
    if (d < 0 || d % 2 != 0) {
      false
    } else {
      val k = d / 2
      val y1 = y0 + 2 * k
      val y2 = y1 - 4 * k - 4
      y >= y2 && y <= y1
    }
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ =>
        val line = StdIn.readLine().split("\\s+").map(_.toLong)
        val x = line(0)
        val y = line(1)

        if (south(x, y) || east(x, y) || north(x, y) || west(x, y)) {
          println("YES")
        } else {
          println("NO")
        }
    }
  }
}
