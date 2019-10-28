package set1000.set1000.set1030.p1039

import scala.collection.mutable

object Solution {
  def minScoreTriangulation(A: Array[Int]): Int = {
    val n = A.length

    val dp = Array.fill(n, n)(Int.MaxValue >> 1)


    for {
      i <- 0 until n
    } {
      dp(i)(0) = 0
      dp(i)(1) = 0
      dp(i)(2) = A(i) * A((i + 1) % n) * A((i + 2) % n)
    }

    for {
      k <- 3 until n
    } {
      for {
        i <- 0 until n
        k1 <- 1 until k
      } {
        val x = (i + k1) % n
        val y = (i + k) % n

        val a = dp(i)(k1) + dp(x)(k - k1) + A(i) * A(x) * A(y)

        dp(i)(k) = dp(i)(k) min a
      }
    }

    dp(0)(n - 1)
  }

  def minScoreTriangulation1(A: Array[Int]): Int = {
    val n = A.length

    val mem = mutable.Map.empty[String, Int]

    def dfs(nodes: Array[Int]): Int = {
      if (nodes.length == 3) {
        A(nodes(0)) * A(nodes(1)) * A(nodes(2))
      } else {
        val key = nodes.sorted.mkString("-")
        if (mem.contains(key)) {
          mem(key)
        } else {
          // try to split nodes into two groups
          var best = Int.MaxValue
          var i = 0
          while (i + 2 < nodes.length) {
            var j = i + 2
            while (j < nodes.length) {
              val first = nodes.slice(i, j + 1)
              val second = nodes.slice(j, nodes.length) ++ nodes.slice(0, i + 1)
              if (second.size >= 3) {
                val a = dfs(first)
                val b = dfs(second)
                if (a + b < best) {
                  best = a + b
                }
              }
              j += 1
            }
            i += 1
          }
          mem(key) = best
          best
        }

      }
    }

    val nodes = (0 until n).toArray

    dfs(nodes)
  }
}
