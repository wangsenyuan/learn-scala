package set0000.set000.set030.p037

object Solution {
  def solveSudoku(board: Array[Array[Char]]): Unit = {
    val rows = Array.fill(9)(0)
    val cols = Array.fill(9)(0)
    val cells = Array.fill(9)(0)

    def isValid(i: Int, j: Int, num: Int): Boolean = {
      val mask = 1 << num

      (rows(i) & mask) == 0 && (cols(j) & mask) == 0 && (cells(i / 3 * 3 + j / 3) & mask) == 0
    }

    def mask(i: Int, j: Int, num: Int) = {
      val mask = 1 << num
      rows(i) |= mask
      cols(j) |= mask
      cells(i / 3 * 3 + j / 3) |= mask
    }

    def unmask(i: Int, j: Int, num: Int) = {
      val mask = 1 << num
      rows(i) ^= mask
      cols(j) ^= mask
      cells(i / 3 * 3 + j / 3) ^= mask
    }

    def next(i: Int, j: Int) = {
      if (j == 8) {
        (i + 1, 0)
      } else {
        (i, j + 1)
      }
    }

    var i = 0
    while (i < 9) {
      var j = 0
      while (j < 9) {
        if (board(i)(j) != '.') {
          mask(i, j, board(i)(j) - '0')
        }
        j += 1
      }

      i += 1
    }

    def go(i: Int, j: Int): Boolean = {
      val (u, v) = next(i, j)
      if (i == 9) {
        true
      } else if (board(i)(j) != '.') {
        go(u, v)
      } else {
        var num = 1
        var ok = false
        while (num <= 9 && !ok) {
          if (isValid(i, j, num)) {
            board(i)(j) = (num + '0').toChar
            mask(i, j, num)
            ok = go(u, v)
            if (!ok) {
              unmask(i, j, num)
              board(i)(j) = '.'
            }
          }
          num += 1
        }
        ok
      }
    }

    go(0, 0)
  }
}
