package set1000.set1100.set1120.p1129

import scala.collection.mutable.ArrayBuffer

object Solution {
  val INF = 1 << 20

  def shortestAlternatingPaths(n: Int, red_edges: Array[Array[Int]], blue_edges: Array[Array[Int]]): Array[Int] = {
    val outs = Array.ofDim[ArrayBuffer[(Int, Int)]](n)

    for {
      i <- 0 until n
    } {
      outs(i) = ArrayBuffer.empty
    }

    for {
      edge <- red_edges
      i = edge(0)
      j = edge(1)
    } {
      outs(i) += j -> 0
    }

    for {
      edge <- blue_edges
      i = edge(0)
      j = edge(1)
    } {
      outs(i) += j -> 1
    }

    val dist = Array.ofDim[Int](n, 2)
    for {
      i <- 0 until n
    } {
      dist(i)(0) = INF
      dist(i)(1) = INF
    }

    val que = ArrayBuffer.empty[(Int, Int)]
    dist(0)(0) = 0
    dist(0)(1) = 0

    que += 0 -> 0
    que += 0 -> 1

    var front = 0

    while (front < que.length) {
      val cur = que(front)
      front += 1
      val u = cur._1
      val c = cur._2

      for {
        out <- outs(u)
        if out._2 == 1 - c
      } {
        val v = out._1
        val vc = out._2

        if (dist(v)(vc) == INF) {
          dist(v)(vc) = dist(u)(c) + 1
          que += v -> vc
        }
      }
    }

    val ans = Array.ofDim[Int](n)

    for {
      i <- 0 until n
    } {
      ans(i) = dist(i)(0) min dist(i)(1)
      if (ans(i) == INF) {
        ans(i) = -1
      }
    }

    ans
  }
}
