package set1000.set1200.set1260.p1263

object Solution {
  private val dd = Array(-1, 0, 1, 0, -1)

  def minPushBox(grid: Array[Array[Char]]): Int = {
    val m = grid.length
    val n = grid(0).length
    val vis = Array.ofDim[Int](m, n)
    val que1 = Array.ofDim[Int](m * n)

    def canReach(sx: Int, sy: Int, x: Int, y: Int, bx: Int, by: Int, flag: Int): Boolean = {
      var end = 0
      que1(end) = sx * n + sy
      end += 1
      vis(sx)(sy) = flag
      var front = 0
      var reach = false
      while (front < end && !reach) {
        val cur = que1(front)
        front += 1
        val u = cur / n
        val v = cur % n
        if (u == x && v == y) {
          reach = true
        } else {
          var i = 0
          while (i < 4) {
            val a = u + dd(i)
            val b = v + dd(i + 1)
            if (a >= 0 && a < m && b >= 0 && b < n && grid(a)(b) != '#' && (a != bx || b != by) && vis(a)(b) < flag) {
              vis(a)(b) = flag
              que1(end) = a * n + b
              end += 1
            }
            i += 1
          }
        }
      }
      reach
    }

    val dist = Array.fill(m, n, m, n)(-1)

    val (sx, sy) = findPos(grid, 'S')
    val (bx, by) = findPos(grid, 'B')
    dist(sx)(sy)(bx)(by) = 0

    val que = Array.ofDim[Int](m * n * m * n)
    var end = 0
    que(end) = sx * n * m * n + sy * m * n + bx * n + by
    end += 1

    var flag = 0
    var front = 0

    while (front < end) {
      val cur = que(front)
      front += 1
      val a = cur / (n * m * n)
      val b = (cur % (n * m * n)) / (m * n)
      val c = (cur % (m * n)) / n
      val d = cur % n
      // (a, b) for player,  (c, d) for box
      var i = 0
      while (i < 4) {
        // (e, f) is the position for player to stand before pushing
        val e = c + dd(i)
        val f = d + dd(i + 1)
        flag += 1
        var g = -1
        var h = -1
        //        val I = e * n * m * n + f * m * n + c * n + d
        if (e >= 0 && e < m && f >= 0 && f < n && grid(e)(f) != '#') {
          if (canReach(a, b, e, f, c, d, flag)) {
            // push
            g = c - dd(i)
            h = d - dd(i + 1)
          }
        }

        if (g >= 0 && g < m && h >= 0 && h < n && grid(g)(h) != '#') {
          if (dist(c)(d)(g)(h) < 0) {
            dist(c)(d)(g)(h) = dist(a)(b)(c)(d) + 1
            que(end) = c * n * m * n + d * m * n + g * n + h
            end += 1
          }
        }

        i += 1
      }
    }
    val (tx, ty) = findPos(grid, 'T')
    var res = -1
    var i = 0
    while (i < 4) {
      val xx = tx + dd(i)
      val yy = ty + dd(i + 1)
      if (xx >= 0 && xx < m && yy >= 0 && yy < n && dist(xx)(yy)(tx)(ty) >= 0) {
        if (res < 0 || res > dist(xx)(yy)(tx)(ty)) {
          res = dist(xx)(yy)(tx)(ty)
        }
      }

      i += 1
    }

    res
  }

  private def findPlayerPos(x: Int, y: Int, d: Int): (Int, Int) = {
    if (d == 0) {
      (x - 1, y)
    } else if (d == 1) {
      (x, y + 1)
    } else if (d == 2) {
      (x + 1, y)
    } else {
      (x, y - 1)
    }
  }

  private def toIndex(a: Int, b: Int, c: Int, n: Int): Int = {
    a * 4 * n + b * 4 + c
  }

  private def toPos(index: Int, n: Int): (Int, Int, Int) = {
    val d = index % 4
    val y = (index / 4) % n
    val x = (index / 4) / n
    (x, y, d)
  }

  private def findPos(grid: Array[Array[Char]], x: Char): (Int, Int) = {
    var i = 0
    while (i < grid.length) {
      var j = 0
      while (j < grid(i).length) {
        if (grid(i)(j) == x) {
          return (i, j)
        }
        j += 1
      }
      i += 1
    }
    null
  }
}
