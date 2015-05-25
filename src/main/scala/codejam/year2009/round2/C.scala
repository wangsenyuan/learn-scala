package codejam.year2009.round2

import codejam.FileOp
import codejam.bipartite.matching.Graph

import scala.annotation.tailrec

/**
 * Created by senyuanwang on 15/5/25.
 */
object C extends App with FileOp {
  override val filePrefix = "src/main/scala/codejam/year2009/round2/C-large-practice"

  /*def bipartiteMatching(n: Int, cbn: Array[Array[Boolean]]): Int = {
    val prev = Array.fill(n)(-1)

    def findNextDfs(a: Int, visited: Map[Int, Boolean]): Boolean = {
      if (a < 0) true
      else if (visited(a)) false
      else {
        @tailrec
        def goToNext(i: Int): Boolean = {
          if (i == n) false
          else if (!cbn(a)(i)) goToNext(i + 1)
          else if (!findNextDfs(prev(i), visited + (a -> true))) goToNext(i + 1)
          else {
            prev(i) = a
            true
          }
        }
        goToNext(0)
      }
    }

    (0 until n).foldLeft(0) {
      (res, i) =>
        if (!findNextDfs(i, Map.empty.withDefaultValue(false))) res + 1 else res
    }
  }*/

  val T = file.next().toInt

  for {
    t <- 1 to T
  } {
    val line = file.next().split("\\s+").map(_.toInt)
    val n = line(0)
    val k = line(1)
    val prices = Array.fill(n)(Array.fill(k)(0))

    for {
      i <- 0 until n
      priceLine = file.next().split("\\s+").map(_.toInt)
      j <- 0 until k
    } {
      prices(i)(j) = priceLine(j)
    }

//    val cbn = Array.fill(n)(Array.fill(n)(false))

    val graph = new Graph(2 * n)

    for {
      i <- 0 until n
      j <- 0 until n
      if (i != j)
    } {
      var r = true
      for {
        x <- 0 until k
        if (r)
      } {
        r = prices(i)(x) > prices(j)(x)
      }
//      cbn(i)(j) = r
      if(r) {
        graph.addEdge(i, n + j)
      }
    }

//    val res = bipartiteMatching(n, cbn)
    val res = n - graph.bipartiteMatching()
    println(s"Case #$t: $res")
  }
}
