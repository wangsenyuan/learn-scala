package set1000.set1200.set1210.p1210

object Solution {
  def minimumMoves(grid: Array[Array[Int]]): Int = {
    val n = grid.length
    val dist = Array.fill(n, n, 2)(-1)
    // 0 for horizontal, 1 for vertical
    dist(0)(1)(0) = 0
    val N = n * n * 2
    val que = Array.ofDim[Int](N)
    var end = 0
    que(end) = calIndex(0, 1, 0, n)
    end += 1

    var front = 0
    while (front < end) {
      val cur = que(front)
      front += 1
      val (x, y, v) = calPos(cur, n)
      // go right
      if (y < n - 1) {
        if (v == 0) {
          if (grid(x)(y + 1) == 0 && dist(x)(y + 1)(0) < 0) {
            dist(x)(y + 1)(0) = dist(x)(y)(0) + 1
            que(end) = calIndex(x, y + 1, 0, n)
            end += 1
          }
        } else {
          if (grid(x)(y + 1) == 0 && grid(x - 1)(y + 1) == 0 && dist(x)(y + 1)(1) < 0) {
            dist(x)(y + 1)(1) = dist(x)(y)(1) + 1
            que(end) = calIndex(x, y + 1, 1, n)
            end += 1
          }
        }
      }

      // go down
      if (x < n - 1) {
        if (v == 0) {
          if (grid(x + 1)(y) == 0 && grid(x + 1)(y - 1) == 0 && dist(x + 1)(y)(0) < 0) {
            dist(x + 1)(y)(0) = dist(x)(y)(0) + 1
            que(end) = calIndex(x + 1, y, 0, n)
            end += 1
          }
        } else {
          if (grid(x + 1)(y) == 0 && dist(x + 1)(y)(1) < 0) {
            dist(x + 1)(y)(1) = dist(x)(y)(1) + 1
            que(end) = calIndex(x + 1, y, 1, n)
            end += 1
          }
        }
      }

      if (v == 0 && x < n - 1 && grid(x + 1)(y) == 0 && grid(x + 1)(y - 1) == 0 && dist(x + 1)(y - 1)(1) < 0) {
        // turn clockwise
        dist(x + 1)(y - 1)(1) = dist(x)(y)(0) + 1
        que(end) = calIndex(x + 1, y - 1, 1, n)
        end += 1
      }

      if (v == 1 && y < n - 1 && grid(x)(y + 1) == 0 && grid(x - 1)(y + 1) == 0 && dist(x - 1)(y + 1)(0) < 0) {
        dist(x - 1)(y + 1)(0) = dist(x)(y)(1) + 1
        que(end) = calIndex(x - 1, y + 1, 0, n)
        end += 1
      }
    }

    dist(n - 1)(n - 1)(0)
  }

  private def calIndex(x: Int, y: Int, v: Int, n: Int) = {
    x * n * 2 + y * 2 + v
  }

  private def calPos(index: Int, n: Int): (Int, Int, Int) = {
    val v = index % 2
    val y = (index / 2) % n
    val x = (index / 2) / n
    (x, y, v)
  }
}
