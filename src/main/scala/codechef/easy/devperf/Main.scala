package codechef.easy.devperf

import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()
    (0 until t) foreach {
      _ => solve()
    }
  }

  def solve(): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val m = firstLine(1)

    var a = 0
    var b = n
    var c = 0
    var d = m

    var i = 0
    while (i < n) {
      val s = StdIn.readLine()

      var j = 0
      while (j < m) {
        if (s(j) == '*') {
          a = i max a
          b = i min b
          c = j max c
          d = j min d
        }
        j += 1
      }

      i += 1
    }


    val ans = if (b == n) {
      0
    } else {
      ((a - b + 1) max (c - d + 1)) / 2 + 1
    }

    println(ans)
  }
}
