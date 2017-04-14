package codechef.easy.ni02

import scala.collection.mutable
import scala.io.StdIn

/**
  * Created by wangsenyuan on 14/04/2017.
  */
object Main {

  def square(x: Int): Long = 1L * x * x

  case class Point(index: Int, x: Int, y: Int) {
    def distance(that: Point): Long = {
      square(this.x - that.x) + square(this.y - that.y)
    }
  }


  def solve(): Unit = {
    val n = StdIn.readInt()
    val m = n + 2
    val points = Array.fill[Point](m)(null)

    var i = 0
    while (i < m) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt)
      points(i) = Point(i, line(0), line(1))
      i += 1
    }

    val d = Array.fill(m)(Long.MaxValue)
    d(n) = 0

    val orderByDist = new Ordering[(Int, Long)] {
      override def compare(x: (Int, Long), y: (Int, Long)): Int = {
        if (x._2 < y._2) {
          1
        } else if (x._2 > y._2) {
          -1
        } else {
          0
        }
      }
    }

    val queue = new mutable.PriorityQueue[(Int, Long)]()(orderByDist)
    queue.enqueue(n -> 0L)

    val checked = Array.fill(m)(false)

    while (!queue.isEmpty) {
      val (j, dj) = queue.dequeue()
      if (!checked(j)) {
        checked(j) = true
        val pj = points(j)
        var k = 0
        while (k < m) {
          val dd = pj.distance(points(k))
          if (!checked(k) && d(k) > dj + dd) {
            d(k) = dj + dd
            queue.enqueue(k -> d(k))
          }

          k += 1
        }
      }
    }

    println(d(m - 1))
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ => solve()
    }
  }
}
