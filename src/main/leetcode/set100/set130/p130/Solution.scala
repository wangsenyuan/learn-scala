package set100.set130.p130

object Solution {
  val dd = Array(-1, 0, 1, 0, -1)

  def solve(board: Array[Array[Char]]): Unit = {
    val m = board.length
    if (m > 0) {
      val n = board(0).length
      if (n > 0) {
        val mat = Array.fill(m, n)(false)

        def dfs(x: Int, y: Int): Unit = {
          mat(x)(y) = true
          for {
            k <- 0 until 4
            u = x + dd(k)
            v = y + dd(k + 1)
            if (u >= 0 && u < m && v >= 0 && v < n && board(u)(v) == 'O' && !mat(u)(v))
          } {
            dfs(u, v)
          }
        }

        for {
          i <- 0 until m
          if board(i)(0) == 'O' && !mat(i)(0)
        } {
          dfs(i, 0)
        }

        for {
          i <- 0 until m
          if board(i)(n - 1) == 'O' && !mat(i)(n - 1)
        } {
          dfs(i, n - 1)
        }

        for {
          j <- 1 until n - 1
          if board(0)(j) == 'O' && !mat(0)(j)
        } {
          dfs(0, j)
        }

        for {
          j <- 1 until n - 1
          if board(m - 1)(j) == 'O' && !mat(m - 1)(j)
        } {
          dfs(m - 1, j)
        }

        for {
          i <- 0 until m
          j <- 0 until n
        } {
          if (!mat(i)(j)) {
            board(i)(j) = 'X'
          }
        }
      }
    }
  }
}
