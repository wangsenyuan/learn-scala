package codechef.easy.chfnfrn

import scala.io.StdIn

/**
  * Created by wangsenyuan on 09/04/2017.
  */
object Main {

  def solve() = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    var m = firstLine(1)

    //true means don't know each know
    val graph = Array.fill(n, n)(true)

    while (m > 0) {
      val line = StdIn.readLine().split("\\s+").map(_.toInt - 1)
      val a = line(0)
      val b = line(1)
      graph(a)(b) = false
      graph(b)(a) = false
      m -= 1
    }

    val color = Array.fill(n)(0)

    val queue = Array.fill(n)(0)

    def bfs(x: Int): Boolean = {
      color(x) = 1
      var p = 0
      queue(p) = x
      p += 1
      var k = 0
      var fail = false
      while (k < p && !fail) {
        val v = queue(k)
        var i = 0
        while (i < n && !fail) {
          if (i != v && graph(i)(v)) {
            //don't know each other
            if (color(i) == 0) {
              //not set yet
              color(i) = color(v) ^ 3
              queue(p) = i
              p += 1
            } else {
              fail = color(i) == color(v)
            }
          }
          i += 1
        }
        k += 1
      }
      !fail
    }

    var fail = false
    var i = 0
    while (i < n && !fail) {
      if (color(i) == 0) {
        fail = !bfs(i)
      }
      i += 1
    }
    if (fail) {
      println("NO")
    } else {
      println("YES")
    }
  }

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()
    var i = 0
    while (i < t) {
      solve()
      i += 1
    }
  }
}
