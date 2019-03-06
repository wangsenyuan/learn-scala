package set400.set400.p407

import scala.collection.mutable

object Solution {

  val dd = Array(-1, 0, 1, 0, -1)

  def trapRainWater(heightMap: Array[Array[Int]]): Int = {
    val m = heightMap.length
    if (m == 0) {
      0
    } else {
      val n = heightMap(0).length
      if (n == 0) {
        0
      } else {
        val pq = mutable.PriorityQueue.empty(new Ordering[(Int, Int)]() {
          override def compare(x: (Int, Int), y: (Int, Int)): Int = {
            if (x._2 < y._2) {
              1
            } else if (x._2 > y._2) {
              -1
            } else {
              0
            }
          }
        })

        val vis = Array.ofDim[Boolean](m, n)
        for {
          i <- 0 until m
        } {
          vis(i)(0) = true
          pq.enqueue((i * n) -> heightMap(i)(0))
          vis(i)(n - 1) = true
          pq.enqueue(((i * n + n - 1) -> heightMap(i)(n - 1)))
        }

        for {
          j <- 1 until n - 1
        } {
          vis(0)(j) = true
          pq.enqueue(j -> heightMap(0)(j))
          vis(m - 1)(j) = true
          pq.enqueue(((m - 1) * n + j) -> heightMap(m - 1)(j))
        }

        var res = 0

        while (!pq.isEmpty) {
          val (pos, h) = pq.dequeue()
          val x = pos / n
          val y = pos % n
          for {
            k <- 0 until 4
            u = x + dd(k)
            v = y + dd(k + 1)
            if (u >= 0 && u < m)
            if (v >= 0 && v < n)
            if (!vis(u)(v))
          } {
            res += 0 max (h - heightMap(u)(v))
            vis(u)(v) = true
            pq.enqueue((u * n + v) -> (heightMap(u)(v) max h))
          }
        }

        res
      }
    }
  }
}
