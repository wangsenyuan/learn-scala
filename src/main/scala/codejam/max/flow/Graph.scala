package codejam.max.flow

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
 * Created by senyuanwang on 15/5/27.
 */
class Graph(val size: Int) {

  case class Edge(to: Int, var cap: Int, rev: Int)

  private val graph = Array.fill(size)(ListBuffer.empty[Edge])

  def addEdge(from: Int, to: Int, cap: Int): Unit = {
    val edgesOfFrom = graph(from)
    val edgesOfTo = graph(to)
    graph(from) += Edge(to, cap, edgesOfTo.size)
    graph(to) += Edge(from, 0, edgesOfFrom.size - 1)
  }

  private def bfs(s: Int, level: Array[Int]): Unit = {
    //    val level = Array.fill(size)(-1)
    for {
      i <- 0 until level.length
    } {
      level(i) = -1
    }

    val que = mutable.Queue.empty[Int]
    que.enqueue(s)
    level(s) = 0

    while (!que.isEmpty) {
      val v = que.dequeue()
      for {
        i <- 0 until graph(v).size
        e = graph(v)(i)
        if (e.cap > 0 && level(e.to) < 0)
      } {
        level(e.to) = level(v) + 1
        que.enqueue(e.to)
      }
    }
    //    level
  }

  private def dfs(v: Int, t: Int, f: Int, iter: Array[Int], level: Array[Int]): Int = {
    if (v == t) f
    else {
      def go(i: Int): (Int, Int) = {
        if (i == graph(v).size) (i, 0)
        else {
          val edge = graph(v)(i)
          if (edge.cap > 0 && level(v) < level(edge.to)) {
            val d = dfs(edge.to, t, f min edge.cap, iter, level)
            if (d > 0) {
              edge.cap -= d
              graph(edge.to)(edge.rev).cap += d
              (i, d)
            } else {
              go(i + 1)
            }
          } else {
            go(i + 1)
          }
        }
      }
      val (i, d) = go(iter(v))
      iter(v) = i
      d
    }
  }

  def maxFlow(s: Int, t: Int): Int = {
    var flow = 0
    val level = Array.fill(size)(-1)
    var stop = false
    while (!stop) {
      bfs(s, level)
      if (level(t) > 0) {
        val iter = Array.fill(size)(0)
        var f = dfs(s, t, Int.MaxValue, iter, level)
        while (f > 0) {
          flow += f
          f = dfs(s, t, Int.MaxValue, iter, level)
        }
      } else {
        stop = true
      }
    }
    flow
  }
}
