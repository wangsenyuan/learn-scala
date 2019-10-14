package set0000.set900.set990.p999

object Solution {
  def numRookCaptures(board: Array[Array[Char]]): Int = {
    var x = 0
    var y = 0
    for {
      i <- 0 until 8
      j <- 0 until 8
      if board(i)(j) == 'R'
    } {
      x = i
      y = j
    }

    var res = 0

    var u = x - 1
    while (u >= 0 && board(u)(y) == '.') {
      u -= 1
    }
    if (u >= 0 && board(u)(y) == 'p') {
      res += 1
    }
    u = x + 1
    while (u < 8 && board(u)(y) == '.') {
      u += 1
    }
    if (u < 8 && board(u)(y) == 'p') {
      res += 1
    }

    var v = y - 1
    while (v >= 0 && board(x)(v) == '.') {
      v -= 1
    }
    if (v >= 0 && board(x)(v) == 'p') {
      res += 1
    }

    v = y + 1
    while (v < 8 && board(x)(v) == '.') {
      v += 1
    }
    if (v < 8 && board(x)(v) == 'p') {
      res += 1
    }
    res
  }
}
