package set200.set200.p200

object Solution {

  val dd = Array(-1, 0, 1, 0, -1)

  def numIslands(grid: Array[Array[Char]]): Int = {
    val m = grid.length
    if (m == 0) {
      0
    } else {
      val n = grid(0).length
      if (n == 0) {
        0
      } else {
        val que = Array.fill(m * n)(-1)
        val flag = Array.fill(m, n)(0)

        def visit(x: Int, y: Int, label: Int): Unit = {
          var front = 0
          var end = 0
          que(end) = x * n + y
          end += 1
          flag(x)(y) = label

          while (front < end) {
            val cur = que(front)
            front += 1
            val i = cur / n
            val j = cur % n
            for {
              k <- 0 until 4
              u = i + dd(k)
              v = j + dd(k + 1)
              if u >= 0 && u < m && v >= 0 && v < n && grid(u)(v) == '1' && flag(u)(v) == 0
            } {
              flag(u)(v) = label
              que(end) = u * n + v
              end += 1
            }
          }
        }


        var label = 0
        for {
          i <- 0 until m
          j <- 0 until n
          if flag(i)(j) == 0 && grid(i)(j) == '1'
        } {
          label += 1
          visit(i, j, label)
        }
        label
      }
    }
  }
}
