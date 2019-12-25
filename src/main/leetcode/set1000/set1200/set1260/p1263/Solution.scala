package set1000.set1200.set1260.p1263

object Solution {
  def minPushBox(grid: Array[Array[Char]]): Int = {
    -1
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

  private val dd = Array(-1, 0, 1, 0, -1)

  private def canReach(grid: Array[Array[Char]], a: Int, b: Int, c: Int, d: Int, bx: Int, by: Int): Boolean = {
    val m = grid.length
    val n = grid(0).length
    if (c < 0 || c >= m || d < 0 || d >= n) {
      false
    } else {
      val vis = Array.ofDim[Boolean](m, n)
      val que = Array.ofDim[Int](m * n)
      var end = 0
      que(end) = a * n + b
      end += 1
      vis(a)(b) = true

      var front = 0
      while (front < end) {
        val cur = que(front)
        front += 1
        val x = cur / n
        val y = cur % n
        if (x == c && y == d) {
          return true
        }
        var i = 0
        while (i < 4) {
          val u = x + dd(i)
          val v = y + dd(i + 1)
          if (u >= 0 && u < m && v >= 0 && v < n && !vis(u)(v) && (grid(u)(v) != '#') && (u != bx || v != by)) {
            vis(u)(v) = true
            que(end) = u * n + v
            end += 1
          }
          i += 1
        }
      }
      false
    }
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
