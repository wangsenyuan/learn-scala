package set800.set830.p834

import scala.collection.mutable.ArrayBuffer

object Solution {
  def sumOfDistancesInTree(N: Int, edges: Array[Array[Int]]): Array[Int] = {
    if (N == 0) {
      Array()
    } else {
      val outs = Array.ofDim[ArrayBuffer[Int]](N)

      (0 until N).foreach(i => outs(i) = ArrayBuffer.empty[Int])

      edges.foreach(edge => {
        val a = edge(0)
        val b = edge(1)
        outs(a) += b
        outs(b) += a
      })

      val cc = Array.ofDim[Int](N)
      val res = Array.ofDim[Int](N)

      def dfs0(p: Int, u: Int): Int = {
        cc(u) = 1
        outs(u).foreach(v => {
          if (p != v) {
            res(u) += dfs0(u, v)
            res(u) += cc(v)
            cc(u) += cc(v)
          }
        })

        res(u)
      }

      res(0) = dfs0(-1, 0)

      def dfs1(p: Int, u: Int): Unit = {
        // we already know res(u)
        // we need to calculate res(v)
        outs(u).foreach(v => {
          if (p != v) {
            val a = res(u) - res(v) - cc(v)
            val b = N - cc(v)
            res(v) = a + res(v) + b
            dfs1(u, v)
          }
        })
      }

      dfs1(-1, 0)

      res
    }
  }
}
