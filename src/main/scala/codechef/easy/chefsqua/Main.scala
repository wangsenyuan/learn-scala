package codechef.easy.chefsqua

import scala.collection.mutable
import scala.io.StdIn

/**
  * Created by wangsenyuan on 16/05/2017.
  */
object Main {

  case class Point(x: Int, y: Int) {
  }

  def needMore(a: Point, b: Point, set: mutable.Set[Point]): Int = {
    val Point(x1, y1) = a
    val Point(x2, y2) = b
    val d = Point(x1 + y1 - y2, y1 + x2 - x1)
    val c = Point(x2 + y1 - y2, y2 + x2 - x1)

    if (set.contains(d) && set.contains(c)) {
      0
    } else if (set.contains(d) || set.contains(c)) {
      1
    } else {
      2
    }
  }

  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()

    val points = Array.fill[Point](n)(null)
    var i = 0
    val set = mutable.Set.empty[Point]
    while (i < n) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      points(i) = Point(line(0), line(1))
      set += points(i)
      i += 1
    }

    if (n == 0) {
      println(4)
    } else if (n == 1) {
      println(3)
    } else if (n == 2) {
      println(2)
    } else {
      var res = 4
      i = 0
      while (i < n) {
        var j = i + 1
        while (j < n) {
          val tmp = needMore(points(i), points(j), set)
          if (tmp < res) {
            res = tmp
          }
          j += 1
        }

        i += 1
      }

      println(res)
    }
  }
}
