package set0000.set100.set140.p149


/**
  * Definition for a point.
  **/
class Point(var _x: Int, var _y: Int) {
  var x: Int = _x
  var y: Int = _y
}

object Solution {

  import scala.collection.mutable

  def maxPoints(points: Array[Point]): Int = {
    val n = points.length
    if (n <= 2) {
      n
    } else {
      val ps = points.sortWith((a, b) => a.x < b.x || (a.x == b.x && a.y < b.y))
      val cnts = Array.fill(n)(1)
      var p = 1
      var q = 0
      var k = 0
      while (p <= n) {
        if (p == n || (ps(p).x != ps(q).x || ps(p).y != ps(q).y)) {
          ps(k) = ps(p - 1)
          cnts(k) = p - q
          k += 1
          q = p
        }
        p += 1
      }

      if (k == 1) {
        cnts(0)
      } else {
        val dp = Array.fill[mutable.Map[(Int, Int), Int]](k)(null)

        for {
          i <- 0 until k
        } {
          dp(i) = mutable.Map.empty[(Int, Int), Int].withDefaultValue(cnts(i))
        }


        for {
          i <- 1 until k
          j <- 0 until i
        } {
          val a = ps(i)
          val b = ps(j)
          val dx = a.x - b.x
          val dy = a.y - b.y
          val g = gcd(dx, dy)
          val angle = (dx / g) -> (dy / g)
          val cnt = dp(j)(angle)

          dp(i) += angle -> (cnt + cnts(i))
        }

        dp.flatMap(_.map(_._2)).max
      }
    }
  }

  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) {
      a
    } else {
      gcd(b, a % b)
    }
  }
}
