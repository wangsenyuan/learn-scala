package set0000.set900.set940.p943

import scala.collection.mutable.ArrayBuffer

object Solution {
  def shortestSuperstring(A: Array[String]): String = {
    val n = A.length
    val dist = Array.ofDim[Int](n, n)

    for {
      i <- 0 until n
      j <- 0 until n
    } {
      dist(i)(j) = overlap(A(i), A(j))
    }

    val N = 1 << n
    val dp = Array.fill(N, n)(Int.MaxValue)

    (0 until n).foreach(i => dp(1 << i)(i) = A(i).length)

    val prev = Array.ofDim[Int](N, n)

    var state = 1
    while (state < N) {
      var i = 0
      while (i < n) {
        if ((state & (1 << i)) > 0) {
          var j = 0
          while (j < n) {
            if ((state & (1 << j)) == 0) {
              // try calculate dp(state | 1<<j)(j)
              val next = state | 1 << j
              if (dp(next)(j) > dp(state)(i) + dist(i)(j)) {
                prev(next)(j) = state * n + i
                dp(next)(j) = dp(state)(i) + dist(i)(j)
              }
            }
            j += 1
          }

        }

        i += 1
      }

      state += 1
    }

    var i = findMinCostAt(dp(N - 1))

    val buf = ArrayBuffer.empty[Int]
    var cur = N - 1
    while (cur > 0) {
      buf += i
      val ps = prev(cur)(i)
      cur = ps / n
      i = ps % n
    }

    val res = new java.lang.StringBuilder()

    i = buf.length - 1
    while (i >= 0) {
      if (i == buf.length - 1) {
        res.append(A(buf(i)))
      } else {
        val a = buf(i + 1)
        val b = buf(i)
        val d = dist(a)(b)
        val s = A(b)
        res.append(s.substring(s.length - d))
      }

      i -= 1
    }
    res.toString
  }

  private def findMinCostAt(xs: Array[Int]): Int = {
    var r = 0
    var i = 1
    while (i < xs.length) {
      if (xs(i) < xs(r)) {
        r = i
      }
      i += 1
    }
    r
  }

  private def overlap(a: String, b: String): Int = {
    val r = (0 until a.length).find(i => {
      val c = a.substring(i)
      b.startsWith(c)
    })
    r match {
      case None => b.length
      case Some(x) => b.length - a.length + x
    }
  }
}
