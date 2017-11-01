package codechef.easy.rhouse

import scala.io.StdIn

object Main {

  def main(args: Array[String]): Unit = {
    val t = StdIn.readInt()
    var i = 0
    while (i < t) {
      solve()
      i += 1
    }
  }

  def solve(): Unit = {
    val firstLine = StdIn.readLine().split("\\s+").map(_.toInt)
    val n = firstLine(0)
    val m = firstLine(1)
    val buildings = StdIn.readLine().toCharArray

    val set = (0 until n).toArray

    def find(x: Int): Int = {
      if (x != set(x)) {
        set(x) = find(set(x))
      }
      set(x)
    }

    val edges = Array.fill[(Int, Int, Int)](m)(null)
    var i = 0
    while (i < m) {
      val edge = StdIn.readLine().split("\\s+").map(_.toInt)
      val x = edge(0) - 1
      val y = edge(1) - 1
      val z = edge(2)
      edges(i) = (x, y, z)
      i += 1
    }

    val sortedEdges = edges.sortBy(_._3)

    val cc = buildings.map(_ == 'R')
    var ans = 0L
    sortedEdges.foreach {
      case (x, y, z) =>
        val px = find(x)
        val py = find(y)

        if (px != py && (!cc(px) || !cc(py))) {
          set(px) = py
          cc(px) |= cc(py)
          cc(py) |= cc(px)
          ans += z
        } else if (z < 0) {
          ans += z
        }
    }

    println(ans)
  }
}
