package codechef.easy.prpotion

import scala.annotation.tailrec
import scala.io.StdIn

/**
  * Created by wangsenyuan on 19/01/2017.
  */
object Main {

  def playMagic(r: Int, g: Int, b: Int, m: Int) = {

    def maxIndex(colors: Vector[Int]): (Int, Int) = {
      var i = 0
      var x = 0
      var j = -1
      while (i < colors.length) {
        if (j == -1 || colors(i) > x) {
          x = colors(i)
          j = i
        }

        i += 1
      }

      (j, x)
    }

    @tailrec
    def go(colors: Vector[Int], m: Int): Int = {
      if (m == 0) {
        colors.max
      } else {
        val (i, x) = maxIndex(colors)
        if (x == 0) {
          x
        } else {
          go(colors.updated(i, x / 2), m - 1)
        }
      }
    }

    go(Vector(r, g, b), m)
  }

  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()

    while (t > 0) {
      val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
      val m = firstLine(3)
      val r = StdIn.readLine().split("\\s+").map(_.toInt).max
      val g = StdIn.readLine().split("\\s+").map(_.toInt).max
      val b = StdIn.readLine().split("\\s+").map(_.toInt).max
      val res = playMagic(r, g, b, m)

      println(res)

      t -= 1
    }
  }
}
