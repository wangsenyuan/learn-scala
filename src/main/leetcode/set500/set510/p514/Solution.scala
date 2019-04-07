package set500.set510.p514

import scala.collection.mutable

object Solution {
  val INF = Int.MaxValue >> 1

  def findRotateSteps(ring: String, key: String): Int = {
    if (key.isEmpty) {
      0
    } else {
      val m = ring.length
      val n = key.length
      val dp = Array.fill(m, n)(INF)
      for {
        i <- 0 until m
        if (ring(i) == key(0))
      } {
        dp(i)(0) = (i min (m - i)) + 1
      }

      for {
        j <- 0 until n - 1
        i <- 0 until m
        if dp(i)(j) < INF
      } {
        for {
          k <- 0 until m
          if ring(k) == key(j + 1)
        } {
          val diff1 = (k - i + m) % m
          val diff2 = (i - k + m) % m
          val diff = diff1 min diff2
          dp(k)(j + 1) = dp(k)(j + 1) min (dp(i)(j) + diff + 1)
        }
      }

      var ans = INF
      for {
        i <- 0 until m
      } {
        ans = ans min dp(i)(n - 1)
      }
      if (ans < INF) {
        ans
      } else {
        -1
      }
    }
  }

  def findRotateSteps1(ring: String, key: String): Int = {
    val cache = mutable.Map.empty[Int, Int]
    val m = ring.length
    val n = key.length

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
