package set0000.set500.set520.p529

object Solution {
  def updateBoard(board: Array[Array[Char]], click: Array[Int]): Array[Array[Char]] = {
    val m = board.length
    val n = board(0).length

    def countMine(x: Int, y: Int) = {
      var res = 0
      for {
        i <- -1 to 1
        u = x + i
        if (u >= 0 && u < m)
        j <- -1 to 1
        v = y + j
        if (v >= 0 && v < n && (u != x || v != y))
        if (board(u)(v) == 'M')
      } {
        res += 1
      }

      res
    }

    val a = click(0)
    val b = click(1)
    if (board(a)(b) == 'M') {
      // boom
      board(a)(b) = 'X'
    } else {
      val que = Array.ofDim[Int](m * n)
      var front = 0
      var end = 0
      que(end) = a * n + b
      end += 1
      while (front < end) {
        val cur = que(front)
        front += 1
        val x = cur / n
        val y = cur % n
        val cnt = countMine(x, y)
        if (cnt == 0) {
          board(x)(y) = 'B'
          for {
            i <- -1 to 1
            u = x + i
            if (u >= 0 && u < m)
            j <- -1 to 1
            v = y + j
            if (v >= 0 && v < n && (u != x || v != y))
            if (board(u)(v) == 'E')
          } {
            board(u)(v) = 'F'
            que(end) = u * n + v
            end += 1
          }
        } else {
          board(x)(y) = ('0' + cnt).toChar
        }
      }
    }

    board
  }
}
