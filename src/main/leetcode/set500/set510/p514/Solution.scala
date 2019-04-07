package set500.set510.p514

import scala.collection.mutable

object Solution {
  def findRotateSteps(ring: String, key: String): Int = {
    val cache = mutable.Map.empty[Int, Int]
    val m = ring.length
    val n = key.length
    val INF = Int.MaxValue >> 1

    def go(i: Int, j: Int): Int = {
      if (j == n) {
        0
      } else {
        val k = i * n + j
        if (!cache.contains(k)) {
          // rotate clockwise
          var best = INF
          for {
            u <- 0 until m
            x = (i + u) % m
            if ring(x) == key(j)
          } {
            val tmp = go(x, j + 1) + u
            best = best min tmp
          }
          // rotate anti-clockwise
          for {
            u <- 0 until m
            x = (i - u + m) % m
            if (ring(x) == key(j))
          } {
            val tmp = go(x, j + 1) + u
            best = best min tmp
          }

          cache(k) = best + 1
        }
        cache(k)
      }
    }

    val res = go(0, 0)
    if (res >= INF) {
      -1
    } else {
      res
    }
  }
}
