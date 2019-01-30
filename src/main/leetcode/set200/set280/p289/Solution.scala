package set200.set280.p289

object Solution {
  def gameOfLife(board: Array[Array[Int]]): Unit = {
    val m = board.length
    if (m > 0) {
      val n = board(0).length
      if (n > 0) {
        def liveNeighbors(x: Int, y: Int): Int = {
          var cnt = 0
          for {
            i <- -1 to 1
            j <- -1 to 1
            u = x + i
            v = y + j
            if u >= 0 && u < m && v >= 0 && v < n
          } {
            cnt += board(u)(v)
          }
          cnt - board(x)(y)
        }

        val after = for {
          i <- 0 until board.length
          j <- 0 until board(0).length
          cnt = liveNeighbors(i, j)
        } yield {
          if (cnt < 2 || cnt > 3) {
            0
          } else if (cnt == 3) {
            1
          } else {
            board(i)(j)
          }
        }

        for {
          i <- 0 until m
          j <- 0 until n
        } {
          board(i)(j) = after(i * n + j)
        }
      }
    }
  }
}
