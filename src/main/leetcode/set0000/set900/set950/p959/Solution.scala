package set0000.set900.set950.p959

import scala.collection.mutable.ArrayBuffer

object Solution {
  def regionsBySlashes(grid: Array[String]): Int = {
    val n = grid.length
    val m = n * n * 4

    val colors = Array.ofDim[Int](m)

    val que = Array.ofDim[Int](m)

    def bfs(x: Int, y: Int, d: Int, color: Int): Unit = {
      var end = 0

      que(end) = toPos(x, y, d, n)
      end += 1

      colors(que(end - 1)) = color

      var front = 0
      while (front < end) {
        val cur = que(front)
        front += 1
        val (u, v, p) = fromPos(cur, n)
        val s = grid(u)(v)

        val nextPositions = visit(u, v, p, n, s)

        for {
          next <- nextPositions
          if next >= 0 && next < m
        } {
          val (u, v, p) = fromPos(next, n)
          if (u >= 0 && u < n && v >= 0 && v < n && p >= 0 && colors(next) == 0) {
            colors(next) = color
            que(end) = next
            end += 1
          }
        }
      }
    }

    var color = 0
    var i = 0
    while (i < m) {
      if (colors(i) == 0) {
        val (x, y, d) = fromPos(i, n)
        color += 1
        bfs(x, y, d, color)
      }
      i += 1
    }

    color
  }

  def toPos(x: Int, y: Int, d: Int, n: Int) = {
    if (x < 0 || x >= n || y < 0 || y >= n || d < 0 || d >= 4) {
      -1
    } else {
      (x * n + y) * 4 + d
    }
  }

  def fromPos(pos: Int, n: Int): (Int, Int, Int) = {
    val d = pos % 4
    val y = (pos / 4) % n
    val x = (pos / 4) / n
    (x, y, d)
  }

  private def visit(x: Int, y: Int, d: Int, n: Int, s: Char): Array[Int] = {
    val buf = ArrayBuffer.empty[Int]

    if (s == '\\') {
      visitRight(x, y, d, n, buf)
    } else if (s == '/') {
      visitLeft(x, y, d, n, buf)
    } else if (s == ' ') {
      buf += toPos(x, y, 0, n)
      buf += toPos(x, y, 1, n)
      buf += toPos(x, y, 2, n)
      buf += toPos(x, y, 3, n)
    }

    if (d == 0) {
      buf += toPos(x - 1, y, 2, n)
    } else if (d == 1) {
      buf += toPos(x, y + 1, 3, n)
    } else if (d == 2) {
      buf += toPos(x + 1, y, 0, n)
    } else {
      buf += toPos(x, y - 1, 1, n)
    }

    buf.toArray
  }

  private def visitRight(x: Int, y: Int, d: Int, n: Int, buf: ArrayBuffer[Int]): Unit = {
    if (d == 0) {
      buf += toPos(x, y, 1, n)
    } else if (d == 1) {
      buf += toPos(x, y, 0, n)
    } else if (d == 2) {
      buf += toPos(x, y, 3, n)
    } else {
      // d == 3
      buf += toPos(x, y, 2, n)
    }
  }

  private def visitLeft(x: Int, y: Int, d: Int, n: Int, buf: ArrayBuffer[Int]): Unit = {
    if (d == 0) {
      buf += toPos(x, y, 3, n)
    } else if (d == 1) {
      buf += toPos(x, y, 2, n)
    } else if (d == 2) {
      buf += toPos(x, y, 1, n)
    } else {
      // d == 3
      buf += toPos(x, y, 0, n)
    }
  }
}
