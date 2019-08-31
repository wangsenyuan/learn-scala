package set0000.set800.set880.p886

import scala.collection.mutable.ArrayBuffer

object Solution {
  def possibleBipartition(N: Int, dislikes: Array[Array[Int]]): Boolean = {
    val conn = Array.ofDim[ArrayBuffer[Int]](N)

    (0 until N).foreach(i => conn(i) = ArrayBuffer.empty[Int])

    dislikes.foreach(dislike => {
      val i = dislike(0) - 1
      val j = dislike(1) - 1
      conn(i) += j
      conn(j) += i
    })

    val colors = Array.ofDim[Int](N)

    def dfs(u: Int, color: Int): Boolean = {
      if (colors(u) != 0) {
        colors(u) == color
      } else {
        colors(u) = color
        conn(u).forall(dfs(_, -color))
      }
    }

    var u = 0
    while (u < N) {
      if (colors(u) == 0) {
        val res = dfs(u, 1)
        if (!res) {
          return false
        }
      }
      u += 1
    }

    true
  }
}
