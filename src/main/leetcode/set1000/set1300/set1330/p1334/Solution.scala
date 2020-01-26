package set1000.set1300.set1330.p1334

object Solution {
  val INF = 1 << 20

  def findTheCity(n: Int, edges: Array[Array[Int]], distanceThreshold: Int): Int = {
    val dist = Array.fill(n, n)(INF)

    for {
      edge <- edges
    } {
      val u = edge(0)
      val v = edge(1)
      dist(u)(v) = edge(2)
      dist(v)(u) = edge(2)
    }

    for {
      k <- 0 until n
      i <- 0 until n
      j <- 0 until n
    } {
      dist(i)(j) = dist(i)(j) min (dist(i)(k) + dist(k)(j))
    }

    var res = 0
    var cnt = INF

    for {
      i <- 0 until n
    } {
      var tmp = 0
      for {
        j <- 0 until n
        if (i != j && dist(i)(j) <= distanceThreshold)
      } {
        tmp += 1
      }
      if (tmp <= cnt) {
        cnt = tmp
        res = i
      }
    }

    res
  }
}
