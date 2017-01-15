package codechef.easy.homdel

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/1/15.
  */
object Main {

  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()

    val t = Array.fill(n, n)(0)

    var i = 0
    while (i < n) {
      val row = StdIn.readLine().split("\\s+").map(_.toInt)
      var j = 0
      while (j < n) {
        t(i)(j) = row(j)
        j += 1
      }
      i += 1
    }

    var k = 0
    while (k < n) {
      var i = 0
      while (i < n) {
        var j = 0
        while (j < n) {
          t(i)(j) = t(i)(j) min t(i)(k) + t(k)(j)
          j += 1
        }
        i += 1
      }
      k += 1
    }

    var m = StdIn.readInt()
    while (m > 0) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      val s = line(0)
      val g = line(1)
      val d = line(2)
      val x = t(s)(g) + t(g)(d)
      val y = x - t(s)(d)
      println(s"$x $y")
      m -= 1
    }

  }
}
