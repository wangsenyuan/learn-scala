package codejam.year2016.round1c.b

import scala.io.StdIn

/**
  * Created by wangsenyuan on 5/10/16.
  */
object Small extends App {

  private def findLastSetBit(x: Long): Int = {
    var pos = 0
    while (((x >> pos) & 1) == 0) {
      pos += 1
    }
    pos
  }

  def play(b: Int, m: Long): Option[Array[Array[Int]]] = {
    val limit = Math.pow(2, b - 2).toLong
    if (m > limit) {
      None
    } else {
      val g = Array.fill(b, b)(0)
      var _m = m
      if (m == limit) {
        _m = m - 1
      }
      while (_m > 0) {
        val i = findLastSetBit(_m)
        g(0)(b - i - 2) = 1
        _m = _m & (_m - 1)
      }

      if (m == limit) {
        g(0)(b - 1) = 1
      }

      var i = 1
      while (i < b - 1) {
        var j = i + 1
        while (j < b) {
          g(i)(j) = 1
          j += 1
        }
        i += 1
      }

      Some(g)
    }
  }

  val t = StdIn.readInt()

  def printGraph(g: Array[Array[Int]]): Unit = {
    print(g.map(_.mkString("")).mkString("\n"))
  }

  for {
    i <- 1 to t
  } {
    val line = StdIn.readLine().split("\\s+")
    val b = line(0).toInt
    val m = line(1).toLong
    play(b, m) match {
      case None =>
        println(s"Case #$i: IMPOSSIBLE")
      case Some(g) =>
        println(s"Case #$i: POSSIBLE")
        printGraph(g)
    }
  }
}
