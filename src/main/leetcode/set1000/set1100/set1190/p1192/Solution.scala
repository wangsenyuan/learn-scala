package set1000.set1100.set1190.p1192

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object Solution {
  def criticalConnections(n: Int, connections: List[List[Int]]): List[List[Int]] = {
    val outs = Array.ofDim[ArrayBuffer[Int]](n)
    (0 until n).foreach(i => outs(i) = ArrayBuffer.empty[Int])

    connections.foreach(conn => {
      val a = conn.head
      val b = conn.last
      outs(a) += b
      outs(b) += a
    })

    val res = ListBuffer.empty[List[Int]]

    var time = 0

    val euler = Array.fill(n)(-1)

    def dfs(p: Int, u: Int): Int = {
      euler(u) = time
      time += 1

      var rt = n
      for {
        v <- outs(u)
        if (p != v)
      } {
        if (euler(v) >= 0) {
          rt = rt min euler(v)
        } else {
          val x = dfs(u, v)
          if (x > euler(u)) {
            res += List(u, v)
          }
          rt = rt min x
        }
      }
      rt
    }

    dfs(-1, 0)

    res.toList
  }
}
