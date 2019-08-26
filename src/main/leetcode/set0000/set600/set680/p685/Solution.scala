package set0000.set600.set680.p685

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Solution {
  def findRedundantDirectedConnection(edges: Array[Array[Int]]): Array[Int] = {
    val n = edges.length
    val outs = Array.ofDim[mutable.ArrayBuffer[Int]](n)

    (0 until n) foreach (i => outs(i) = mutable.ArrayBuffer.empty[Int])

    val parent = Array.fill(n)(-1)

    val cand = ArrayBuffer.empty[Array[Int]]

    edges.foreach(edge => {
      val u = edge(0) - 1
      val v = edge(1) - 1
      if(parent(v) >= 0) {
        cand += Array(parent(v) + 1, v + 1)
        cand += Array(u + 1, v + 1)
      } else {
        parent(v) = u
        outs(u) += v
      }
    })

    val (root, _) = orbit(0, parent)

    if(cand.isEmpty) {
      val (_, cycle) = orbit(root, parent)
      var i = n - 1
      while(i >= 0) {
        val edge = edges(i)
        if(cycle(edge(0) - 1) && cycle(edge(1) - 1)) {
          return edge
        }
        i -= 1
      }
      return Array()
    }

    val seen = Array.ofDim[Boolean](n)

    def dfs(u: Int): Unit = {
      if(!seen(u)) {
        seen(u) = true
        outs(u).foreach(v => dfs(v))
      }
    }

    dfs(root)

    if(seen.exists(_ == false)) {
      cand(0)
    } else {
      cand(1)
    }
  }

  private def orbit(node: Int, parent: Array[Int]): (Int, Set[Int]) = {
    var seen = Set.empty[Int]
    var root = node
    while(parent(root) >= 0 && !seen(root)) {
      seen += root
      root = parent(root)
    }
    (root, seen)
  }
}
