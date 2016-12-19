package codechef.points

import scala.io.StdIn

/**
  * Created by wangsenyuan on 19/12/2016.
  */
object Main {

  case class Point(x: Int, y: Int) {
    def dist(that: Point) = {
      val dx = that.x - x;
      val dy = that.y - y
      math.sqrt(dx * dx + dy * dy)
    }
  }

  def connect(points: Array[Point], n: Int): Double = {
    val sorted = points.sortWith {
      (a, b) =>
        if (a.x < b.x) {
          true
        } else if (a.x > b.x) {
          false
        } else {
          a.y > b.y
        }
    }

    def go(i: Int, res: Double): Double = {
      if (i == n) {
        res
      } else {
        val prev = sorted(i - 1)
        val cur = sorted(i)
        go(i + 1, cur.dist(prev) + res)
      }
    }

    go(1, 0D)
  }


  def main(args: Array[String]): Unit = {
    var t = StdIn.readInt()
    while (t > 0) {
      t -= 1
      StdIn.readLine()
      val n = StdIn.readInt()
      val points = Array.fill[Point](n)(null)

      var i = 0
      while (i < n) {
        val line = StdIn.readLine().split("\\s+").map(_.toInt)
        points(i) = Point(line(0), line(1))
        i += 1
      }

      val res = connect(points, n)

      println(f"${res}%.2f")
    }
  }
}
