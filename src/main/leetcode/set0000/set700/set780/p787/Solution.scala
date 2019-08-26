package set0000.set700.set780.p787

import scala.collection.mutable.ArrayBuffer

object Solution {
  def findCheapestPrice(n: Int, flights: Array[Array[Int]], src: Int, dst: Int, K: Int): Int = {
    val outs = Array.ofDim[ArrayBuffer[Edge]](n)
    var i = 0
    while (i < n) {
      outs(i) = ArrayBuffer.empty[Edge]
      i += 1
    }

    flights.foreach(flight => {
      val u = flight(0)
      val v = flight(1)
      val c = flight(2)
      outs(u) += Edge(v, c)
    })

    val INF = Int.MaxValue
    val dp = Array.fill(n, K + 3)(INF)

    dp(src)(0) = 0

    var k = 0
    while (k < K + 2) {
      var u = 0
      while (u < n) {

        if (dp(u)(k) < INF) {
          val out = outs(u)
          out.foreach(edge => {
            val v = edge.dst
            val c = edge.cost
            dp(v)(k + 1) = dp(v)(k + 1) min (dp(u)(k) + c)
          })
        }

        u += 1
      }

      u = 0
      while(u < n) {
        dp(u)(k+1) = dp(u)(k) min dp(u)(k + 1)
        u += 1
      }

      k += 1
    }

    val r = dp(dst)(K + 1)
    if(r == INF) {
      -1
    } else {
      r
    }
  }

  case class Edge(dst: Int, cost: Int)

}
