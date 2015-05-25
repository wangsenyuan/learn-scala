package codejam.bipartite.matching

import scala.annotation.tailrec

/**
 * Created by senyuanwang on 15/5/25.
 */

class Graph(val size: Int) {
  val g = Array.fill(size)(Nil: List[Int])

  def addEdge(u: Int, v: Int): Unit = {
    require(u < size && u >= 0)
    require(v < size && v >= 0)
    g(u) = v :: g(u)
    g(v) = u :: g(v)
  }

  private def dfs(v: Int, used: Array[Boolean], pair: Array[Int]): Boolean = {
    used(v) = true

    def go(neighbors: List[Int]): Boolean =
      neighbors match {
        case Nil => false
        case u :: tail =>
          val w = pair(u)
          if (w < 0 || !used(w) && dfs(w, used, pair)) {
            pair(v) = u
            pair(u) = v
            true
          } else {
            go(tail)
          }
      }

    go(g(v))
  }

  def bipartiteMatching(): Int = {
    val pair = Array.fill(size)(-1)

    @tailrec
    def travel(v: Int, res: Int): Int =
      if (v >= size) res
      else if (pair(v) < 0 && dfs(v, Array.fill(size)(false), pair)) {
        travel(v + 1, res + 1)
      } else {
        travel(v + 1, res)
      }

    travel(0, 0)
  }
}