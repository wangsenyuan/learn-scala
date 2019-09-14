package set0000.set900.set930.p934

object Solution {
  val dd = Array(-1, 0, 1, 0, -1)

  def shortestBridge(A: Array[Array[Int]]): Int = {
    val m = A.length
    val n = A(0).length
    val color = Array.ofDim[Int](m, n)

    val que = Array.ofDim[Int](m * n)

    def findIslandOne(x: Int, y: Int): Boolean = {
      var front = 0
      var end = 0
      que(end) = x * n + y
      end += 1
      color(x)(y) = 1
      while (front < end) {
        val cur = que(front)
        front += 1
        val u = cur / n
        val v = cur % n
        var i = 0
        while (i < 4) {
          val a = u + dd(i)
          val b = v + dd(i + 1)
          if (a >= 0 && a < m && b >= 0 && b < n && color(a)(b) == 0 && A(a)(b) == 1) {
            que(end) = a * n + b
            end += 1
            color(a)(b) = 1
          }
          i += 1
        }
      }
      true
    }

    val N = m * n

    (0 until N).exists(pos => {
      val x = pos / n
      val y = pos % n
      A(x)(y) == 1 && findIslandOne(x, y)
    })

    val dist = Array.fill(m, n)(-1)

    var end = 0
    for {
      i <- 0 until m
      j <- 0 until n
      if color(i)(j) == 1
    } {
      que(end) = i * n + j
      end += 1
      dist(i)(j) = 0
    }

    var front = 0
    while (front < end) {
      val cur = que(front)
      front += 1
      val x = cur / n
      val y = cur % n

      if (A(x)(y) == 1 && color(x)(y) == 0) {
        // reach another island
        return dist(x)(y) - 1
      }

      var k = 0
      while (k < 4) {
        val u = x + dd(k)
        val v = y + dd(k + 1)

        if (u >= 0 && u < m && v >= 0 && v < n && dist(u)(v) < 0) {
          dist(u)(v) = dist(x)(y) + 1
          que(end) = u * n + v
          end += 1
        }

        k += 1
      }
    }
    -1
  }
}
