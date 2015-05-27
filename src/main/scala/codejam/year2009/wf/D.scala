package codejam.year2009.wf

import codejam.FileOp
import codejam.max.flow.Graph

/**
 * Created by senyuanwang on 15/5/27.
 */
object D extends App with FileOp {

  override val filePrefix = "src/main/scala/codejam/year2009/wf/D-large-practice"

  def sqr(x: Int) = x * x

  def solve(xs: Array[Int], ys: Array[Int], rs: Array[Int], ss: Array[Int], n: Int): Int = {
    val graph = new Graph(n + 2)

    var ans = 0

    for {
      i <- 0 until n
      x = xs(i)
      y = ys(i)
      r = rs(i)
      s = ss(i)
    } {
      if (s < 0) {
        graph.addEdge(n, i, -s)
      } else {
        ans += s
        graph.addEdge(i, n + 1, s)
      }

      for {
        j <- 0 until n
        if (i != j)
        if (sqr(xs(i) - xs(j)) + sqr(ys(i) - ys(j)) <= sqr(rs(i)))
      } {
        graph.addEdge(j, i, Int.MaxValue)
      }
    }

    ans - graph.maxFlow(n, n + 1)
  }

  val T = file.next().toInt

  for {
    t <- 1 to T
  } {
    val n = file.next().toInt
    val xs = Array.fill(n)(0)
    val ys = Array.fill(n)(0)
    val rs = Array.fill(n)(0)
    val ss = Array.fill(n)(0)
    for {
      i <- 0 until n
      line = file.next().split("\\s+").map(_.toInt)
    } {
      xs(i) = line(0)
      ys(i) = line(1)
      rs(i) = line(2)
      ss(i) = line(3)
    }
    val ans = solve(xs, ys, rs, ss, n)
    println(s"Case #$t: $ans")
  }
}
