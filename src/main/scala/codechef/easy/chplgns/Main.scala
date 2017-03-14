package codechef.easy.chplgns

import scala.io.StdIn

/**
  * Created by wangsenyuan on 14/03/2017.
  */
object Main {


  case class Poly(idx: Int, n: Int, rightMostX: Long)

  def inside(a: Poly, b: Poly): Boolean = {
    a.rightMostX < b.rightMostX
  }

  def solve() = {
    val n = StdIn.readInt()

    val polys = Array.fill[Poly](n)(null)

    var i = 0
    while (i < n) {
      val m = StdIn.readInt()
      val points = StdIn.readLine().split("\\s+").map(_.toLong)
      var j = 0
      var rightX = Long.MinValue
      while (j < m) {
        val x = points(2 * j)
        if (x > rightX) {
          rightX = x
        }
        j += 1
      }

      polys(i) = Poly(i, m, rightX)
      i += 1
    }

    val ps = polys.sortWith(inside)

    val res = Array.fill(n)(0)

    i = 0
    while (i < n) {
      val p = ps(i)
      res(p.idx) = i
      i += 1
    }

    println(s"${res.mkString(" ")}")
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ => solve()
    }
  }
}
