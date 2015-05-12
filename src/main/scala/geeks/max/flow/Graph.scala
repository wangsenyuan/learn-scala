package geeks.max.flow

import java.util

import scala.collection.mutable

/**
 * Created by senyuanwang on 15/5/3.
 */
class Graph(val n: Int) {
  val nodes = Array.fill(n)(Map.empty[Int, Edge])

  def findEdge(v: Int, ith: Int) = nodes(v)(ith)

  def addEdge(from: Int, to: Int, cap: Int): Unit = {
    val fromMap = nodes(from)
    val toMap = nodes(to)
    nodes(from) = fromMap + (fromMap.size -> Edge(to, cap, toMap.size))
    nodes(to) = toMap + (toMap.size -> Edge(from, 0, fromMap.size))
  }

  private def bfs(s: Int, level: Array[Int]): Unit = {
    util.Arrays.fill(level, -1)
    val queue = mutable.Queue.empty[Int]
    level(s) = 0
    queue.enqueue(s)
    while (!queue.isEmpty) {
      val v = queue.dequeue()
      for {
        i <- 0 until nodes(v).size
        edge = nodes(v)(i)
        if (edge.cap > 0 && level(edge.to) < 0)
      } {
        level(edge.to) = level(v) + 1
        queue.enqueue(edge.to)
      }
    }
  }

  class Iter(var pos: Int)

  object Iter {
    def apply(pos: Int) = new Iter(pos)
  }

  private def dfs(v: Int, t: Int, f: Int, iters: Array[Iter], level: Array[Int], path: List[Int]): (Int, List[Int]) = {
    if (v == t) {
      (f, t :: path)
    }
    else {
      val iter = iters(v);
      val edges = nodes(v);
      while (iter.pos < edges.size) {
        val e = nodes(v)(iter.pos)
        if (e.cap > 0 && level(v) < level(e.to)) {
          val (d, p) = dfs(e.to, t, f min e.cap, iters, level, v :: path)
          if (d > 0) {
            e.cap -= d
            findEdge(e.to, e.rev).cap += d
            return (d, p)
          }
        }
        iter.pos += 1;
      }
      (0, Nil)
    }
  }

  def maxFlow(n: Int, s: Int, t: Int): Int = {
    var flow = 0
    val level = Array.fill(n)(-1)
    var found = false
    while (!found) {
      bfs(s, level)
      if (level(t) < 0) {
        found = true
      } else {
        val iters = Array.fill(n)(Iter(0))
        var res = dfs(s, t, Int.MaxValue, iters, level, Nil)
        while (res._1 > 0) {
          flow += res._1
          println(res)
          res = dfs(s, t, Int.MaxValue, iters, level, Nil)
        }
      }
    }
    flow
  }
}

case class Edge(to: Int, var cap: Int, rev: Int)

