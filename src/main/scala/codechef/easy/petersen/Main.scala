package codechef.easy.petersen

import scala.io.StdIn

/**
  * Created by wangsenyuan on 17/03/2017.
  */
object Main {

  val nodes = Array('A', 'B', 'C', 'D', 'E', 'A', 'B', 'C', 'D', 'E')
  val edges = Array(
    Array(1, 4, 5),
    Array(0, 2, 6),
    Array(1, 3, 7),
    Array(2, 4, 8),
    Array(3, 0, 9),
    Array(0, 7, 8),
    Array(1, 8, 9),
    Array(2, 5, 9),
    Array(3, 5, 6),
    Array(4, 6, 7)
  )
  val cs = Map('A' -> Array(0, 5), 'B' -> Array(1, 6), 'C' -> Array(2, 7), 'D' -> Array(3, 8), 'E' -> Array(4, 9))

  def findPath(w: Int, s: String): Option[String] = {
    val sb = new StringBuilder()
    var i = 0
    var v = w
    while (i < s.length && v >= 0) {
      sb.append(v)

      if (i + 1 < s.length) {
        val x = s(i + 1)
        var j = 0
        while (j < 3 && x != nodes(edges(v)(j))) {
          j += 1
        }
        if (j < 3) {
          v = edges(v)(j)
        } else {
          v = -1
        }
      }

      i += 1
    }

    if (i == s.length) {
      Some(sb.toString())
    } else {
      None
    }
  }

  def solve() = {
    val s = StdIn.readLine()

    if (s.isEmpty) {
      println(-1)
    } else {
      val ps = cs(s(0))
      val res = findPath(ps(0), s).orElse(findPath(ps(1), s))
      res match {
        case Some(x) => println(x)
        case None => println(-1)
      }
    }

  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()

    (0 until t) foreach {
      _ => solve()
    }
  }
}
