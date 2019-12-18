package set1000.set1200.set1240.p1240

object Solution {
  def tilingRectangle(n: Int, m: Int): Int = {
    val grid = Array.ofDim[Boolean](n, m)

    def allowSquare(x: Int, y: Int, k: Int): Boolean = {
      var i = x
      while (i < x + k) {
        var j = y
        while (j < y + k) {
          if (grid(i)(j)) {
            return false
          }
          j += 1
        }
        i += 1
      }
      true
    }

    def flipSquare(x: Int, y: Int, k: Int): Unit = {
      var i = x
      while (i < x + k) {
        var j = y
        while (j < y + k) {
          grid(i)(j) = !grid(i)(j)
          j += 1
        }
        i += 1
      }
    }

    def topLeft(): (Int, Int) = {
      var i = 0
      while (i < n) {
        var j = 0
        while (j < m) {
          if (!grid(i)(j)) {
            return (i, j)
          }
          j += 1
        }
        i += 1
      }
      null
    }

    val A = n * m

    var best = Int.MaxValue

    def loop(res: Int, area: Int): Unit = {
      if (area == A) {
        best = best min res
      } else if (res < best) {
        val (x, y) = topLeft()

        var k = (n - x) min (m - y)

        while (k > 0) {
          if (allowSquare(x, y, k)) {
            flipSquare(x, y, k)
            loop(res + 1, area + k * k)
            flipSquare(x, y, k)
          }
          k -= 1
        }
      }
    }

    loop(0, 0)

    best
  }
}
