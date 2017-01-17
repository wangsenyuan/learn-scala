package codechef.easy.retpo

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/1/17.
  */
object Main {

  def moveX(x: Int) = if ((x & 1) == 1) 2 * x + 1 else 2 * x

  def moveY(y: Int) = if ((y & 1) == 1) 2 * y - 1 else 2 * y

  def move(x: Int, y: Int): Int = {
    moveX(x) + moveY(y)
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val x = line(0).abs
      val y = line(1).abs
      val z = x min y

      val res = 2 * z + move(x - z, y - z)
      println(res)

      t -= 1
    }
  }
}
