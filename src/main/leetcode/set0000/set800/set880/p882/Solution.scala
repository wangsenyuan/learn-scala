package set0000.set800.set880.p882

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Solution {
  def reachableNodes(edges: Array[Array[Int]], M: Int, N: Int): Int = {
    val outs = Array.ofDim[ArrayBuffer[Int]](N)
    (0 until N).foreach(i => outs(i) = ArrayBuffer.empty[Int])

    edges.foreach(edge => {
      val i = edge(0)
      val j = edge(1)
      val n = edge(2)
      outs(i) += j
      outs(i) += n

      outs(j) += i
      outs(j) += n
    })

    val pq = mutable.PriorityQueue.empty[Pos](Ordering.by(_.moves))
    pq.enqueue(Pos(0, M))

    val vis = Array.ofDim[Boolean](N)

    val reach = Array.ofDim[Int](N)
    reach(0) = M

    var res = 0

    while (!pq.isEmpty) {
      val pos = pq.dequeue()
      val u = pos.u
      if (!vis(u)) {
        vis(u) = true
        res += 1
        val moves = pos.moves
        if (moves > 0) {
          // add the node
          val next = outs(u)

          var i = 0
          while (i < next.length) {
            val v = next(i)
            val n = next(i + 1)

            if (vis(v)) {
              if (moves + reach(v) <= n) {
                // no overlap
                res += moves
              } else if (n > reach(v)) {
                res += n - reach(v)
              }
            } else {
              if (moves <= n) {
                // it can't reach v
                res += moves
              } else {
                res += n
                reach(v) = reach(v) max (moves - (n + 1))
                pq.enqueue(Pos(v, reach(v)))
              }
            }

            i += 2
          }

        }
      }
    }
    res
  }

  case class Pos(u: Int, moves: Int)

}
