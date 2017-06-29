package codechef.easy.rainbow

import scala.io.StdIn

/**
  * Created by senyuanwang on 2017/6/29.
  */
object Main {

  def readGrid(n: Int) = {
    val grid = Array.fill[Array[Int]](n)(null)
    var i = 0
    while (i < n) {
      val row = StdIn.readLine().split("\\s+").map(_.toInt)
      grid(i) = row
      i += 1
    }
    grid
  }

  def solve() = {
    val n = StdIn.readInt()
    val grid = readGrid(n)

    val colors = grid.map(row => row.groupBy(identity).mapValues(_.size))
    val nodes = (0 until n).toList
    val removed = Array.fill(n)(false)

    def process(nodes: List[Int]): Int = {
      nodes match {
        case Nil => 0
        case h :: tail if colors(h).size > 2 => nodes.size
        case h :: tail if colors(h).size == 1 => process(tail)
        case h :: tail =>
          var i = 0
          while (i < n) {
            if (i != h && !removed(i)) {
              val c = grid(h)(i)
              val cnt = colors(i)(c)
              if (cnt == 1) {
                colors(i) -= c
              } else {
                colors(i) += (c -> (cnt - 1))
              }
            }
            i += 1
          }
          removed(h) = true
          process(tail.sortBy(x => colors(x).size))
      }
    }

    val ans = process(nodes.sortBy(i => colors(i).size))
    println(ans)
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
