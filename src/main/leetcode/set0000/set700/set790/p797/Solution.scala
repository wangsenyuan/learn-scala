package set0000.set700.set790.p797

import scala.collection.mutable.ListBuffer

object Solution {
  def allPathsSourceTarget(graph: Array[Array[Int]]): List[List[Int]] = {

    val n = graph.length
    val res = ListBuffer.empty[List[Int]]

    val tmp = Array.ofDim[Int](n)

    def dfs(u: Int, i: Int): Unit = {
      tmp(i) = u
      if(u == n - 1) {
        res += tmp.take(i + 1).toList
      } else {
        graph(u).foreach(v => {
          dfs(v, i + 1)
        })
      }
    }

    dfs(0, 0)

    res.toList
  }
}
