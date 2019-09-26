package set0000.set900.set960.p963

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.util.Sorting

object Solution {
  def minAreaFreeRect(points: Array[Array[Int]]): Double = {
    val lines = mutable.Map.empty[Slop, ListBuffer[Line]]
    val n = points.length

    // sort by x
    Sorting.quickSort(points)(Ordering.by(_ (0)))

    for {
      i <- 0 until n
      j <- i + 1 until n
    } {
      val a = points(i)(0)
      val b = points(i)(1)
      val c = points(j)(0)
      val d = points(j)(1)

      var slop: Slop = null
      if (a == c) {
        // parallel to Y
        if (b < d) {
          slop = Slop(0, 1)
        } else {
          slop = Slop(0, -1)
        }
      } else if (b == d) {
        slop = Slop(1, 0)
      } else {
        val dx = c - a
        val dy = d - b
        val g = gcd(dx, dy.abs)
        slop = Slop(dx / g, dy / g)
      }
      if (!lines.contains(slop)) {
        lines += slop -> ListBuffer.empty
      }
      lines(slop) += Line(a, b, c, d)
    }

    var best = -1.0
    for {
      (_, ls) <- lines
      if ls.length > 1
    } {
      for {
        i <- 0 until ls.length
        j <- i + 1 until ls.length
      } {
        val line0 = ls(i)
        val line1 = ls(j)
        // line0 // line1
        if (canFormRect(line0, line1)) {
          val area = calcArea(line0, line1)
          if (best < 0 || best > area) {
            best = area
          }
        }
      }
    }

    if (best < 0) {
      0
    } else {
      best
    }
  }

  case class Slop(x: Int, y: Int)

  case class Line(a: Int, b: Int, c: Int, d: Int) {
    val lengthSquare = squareLength(a, b, c, d)
  }

  private def squareLength(a: Int, b: Int, c: Int, d: Int) = (c - a) * (c - a) + (d - b) * (d - b)

  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) {
      a
    } else {
      gcd(b, a % b)
    }
  }

  private def canFormRect(line0: Line, line1: Line): Boolean = {
    if (line0.lengthSquare != line1.lengthSquare) {
      false
    } else {
      val x = line0.lengthSquare
      val y = squareLength(line0.a, line0.b, line1.a, line1.b)
      val z = squareLength(line0.c, line0.d, line1.a, line1.b)
      if (y == 0 || z == 0) {
        false
      } else {
        x + y == z
      }
    }
  }

  private def calcArea(line0: Line, line1: Line): Double = {
    val x = line0.lengthSquare
    val y = squareLength(line0.a, line0.b, line1.a, line1.b)
    Math.sqrt(x) * Math.sqrt(y)
  }
}
